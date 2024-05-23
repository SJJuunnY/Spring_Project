package com.example.shoppingmall.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    UserRepository userRepository;

    public User signUp(User user) {
        userRepository.save(user);
//        String userId = userRepository.find
        return userRepository.findById(user.getUserId());
    }

    public User findUser(int id) {
        return userRepository.findById(id);
    }

    public String signup(User user) {
        return userRepository.signup(user); //userId반환
    }

//    public String login(User user) {
//        return userRepository.isvalid(user); //userId반환
//    }

    public boolean isDuplicate(User user) {
        return userRepository.isvalid(user);
    }
    public boolean checkDuplicateID(String userId) {
          User existUser = userRepository.findById(userId);
        if( existUser == null){ //DB에 없다 야
            return false;
        }else{
            return true;
        }
    }

//    public void makeConnection() {
//        log.info("makeConnection UserService");
//        userRepository.makeConnection();
//    }
}
