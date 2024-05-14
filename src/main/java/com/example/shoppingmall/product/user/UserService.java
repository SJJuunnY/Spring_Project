package com.example.shoppingmall.product.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    public String signup(User user) {
        return userRepository.signup(user); //userId반환
    }

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
}