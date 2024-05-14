package com.example.shoppingmall.product.user;

import com.example.shoppingmall.utils.ApiUtils;
import com.example.shoppingmall.utils.DuplicateUserEx;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.ApiResult;
import static com.example.shoppingmall.utils.ApiUtils.success;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user){
        log.info(user.toString());
        String userId = userService.signup(user);
        return new ResponseEntity<>("환영합니다", HttpStatus.OK);
    }
    @PostMapping("/login")
    public void login(@RequestBody String id, @RequestBody String pw){

    }

    @PostMapping("/login/isvalid")
    public ResponseEntity<Exception> isvalid(@RequestBody User user){

        // ID 중복 체크
        // 중복이면, 사용자 예외클래스 소환
        // 1)예외클래스한테 니가 return해 ( 예외처리 주체가 예외클래스 )
        // 2) 예외만 발생 시키고.. 메세지는 내가 보낼게 ( 예외처리 주체가 컨트롤러 )

        if(userService.checkDuplicateID(user.getUserId())){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        try {
            if (isDuplicate(user))
                throw new DuplicateUserEx("중복된 사용자 입니다.");
            return new ResponseEntity<>(null, HttpStatus.OK);
//            return ApiResult.Success();
        } catch (DuplicateUserEx e){
//            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
//            return ApiResult.fail();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/join/api/result")
    public ApiResult joinByApiResult (@RequestBody User user){
        if(userService.checkDuplicateID(user.getUserId())){
            return error("아이디중독",HttpStatus.CONFLICT);
        }
        String userId = userService.signup(user);
        return success(userId);
    }

    private boolean isDuplicate(User user) {
        return userService.isDuplicate(user);
    }

    @GetMapping("/test")
    public void Test(@RequestBody User user){
        System.out.println(user.toString());
    }
}