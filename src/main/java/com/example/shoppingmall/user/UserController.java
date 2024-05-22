package com.example.shoppingmall.user;

import com.example.shoppingmall.utils.ApiUtils;
import com.example.shoppingmall.utils.DuplicateUserEx;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

//import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.ApiResult;
import static com.example.shoppingmall.utils.ApiUtils.success;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
    UserService userService ;

    @PostMapping("/dbtest/make")
    public ResponseEntity makeUser(
            @RequestBody @Valid User user
    ){
        User Createduser = userService.signUp(user);
        return new ResponseEntity<>(Createduser,HttpStatus.OK);
    }

    @PostMapping("/dbtest/find")
    public ResponseEntity findUser(
            @RequestBody @Valid Map<String, Integer> req
    ){
        System.out.println(req.get("userId"));
        User selectedUser = userService.findUser(req.get("userId"));
        return new ResponseEntity<>(selectedUser,HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid User user, Errors error){
        Map<String,String> errors = new HashMap<>();
        error.getAllErrors().forEach( err -> {
            FieldError fieldError = (FieldError) err;
            String errorMsg = err.getDefaultMessage();

            errors.put(fieldError.getField(),errorMsg);
        });
        if(errors.isEmpty())
            return new ResponseEntity<>(errors.toString(),HttpStatus.BAD_REQUEST);

        log.info(user.toString());
        String userId = userService.signup(user);
        return new ResponseEntity<>("환영합니다", HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public void login(@RequestBody String id, @RequestBody String pw){
//
//    }

    @PostMapping("/login")
    public ApiUtils.ApiResult login(@RequestBody @Valid UserDto userDto){//, Errors error){
//        if(error.hasErrors()){
//            Map<String,String> errorMessages = new HashMap<>();
//            for(FieldError errorElem : error.getFieldErrors()){
//                String errorField = errorElem.getField();
//                String errorMessage = errorElem.getDefaultMessage();
//                errorMessages.put(errorField, errorMessage);
//            }
//        return error(errorMessages, HttpStatus.BAD_REQUEST);


//            error.getAllErrors().forEach( err -> {
//                FieldError fieldError = (FieldError) err;
//                String errorMsg = err.getDefaultMessage();
//                errors.put(fieldError.getField(),errorMsg);
//            });
//        }

//        String userId;
        User user = userDto.convertToEntity();
//        return success(HttpStatus.OK);

        // ID 중복 체크
        // 중복이면, 사용자 예외클래스 소환
        // 1)예외클래스한테 니가 return해 ( 예외처리 주체가 예외클래스 )
        // 2) 예외만 발생 시키고.. 메세지는 내가 보낼게 ( 예외처리 주체가 컨트롤러 )
        System.out.println("hihihihihih");
        if(userService.checkDuplicateID(userDto.getUserId())){
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
            return error("중복ID", HttpStatus.CONFLICT);
        }

        try {
            if (isDuplicate(user))
                throw new DuplicateUserEx("중복된 사용자 입니다.");
//            return new ResponseEntity<>(null, HttpStatus.OK);
            return success(HttpStatus.OK);
//            return ApiResult.Success();
        } catch (DuplicateUserEx e){
//            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
//            return ApiResult.fail();
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
            return error("중복",HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/join/api/result")
    public ApiResult joinByApiResult (@RequestBody UserDto userDto){
        if(userService.checkDuplicateID(userDto.getUserId())){
            return error("아이디중독",HttpStatus.CONFLICT);
        }

        User requestUser= userDto.convertToEntity();
        String userId = userService.signup(requestUser);
        return success(userId);
    }

    private boolean isDuplicate(User user) {
        return userService.isDuplicate(user);
    }

    @GetMapping("/test")
    public void Test(@RequestBody User user){
        System.out.println(user.toString());
    }

    @PostMapping("/test")
    public void Test(@RequestBody UserDto userDto){
        System.out.println(userDto.toString());
    }
    
    //유효성 검사하다가 에러가 터지면 호출되는 예외처리 메소드
    @ExceptionHandler(MethodArgumentNotValidException.class)//매개변수에 있으면 안넣어줘도 된다
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult<Map<String, String>> handleValidationException(MethodArgumentNotValidException errors){
//        if(error.hasErrors()){ //에러가 있을떄 발생되므로 굳이 필요 없다
            Map<String,String> errorMessages = new HashMap<>();

            for(FieldError errorElem : errors.getFieldErrors()){
                String errorField = errorElem.getField();
                String errorMessage = errorElem.getDefaultMessage();
                errorMessages.put(errorField, errorMessage);
            }
            return error(errorMessages, HttpStatus.BAD_REQUEST);
    }
}