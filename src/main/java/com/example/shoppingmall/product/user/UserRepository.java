package com.example.shoppingmall.product.user;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    Map<String,User> userTable = new HashMap<>();

    int id = 0;

    public String signup(User user){
        System.out.println(user.toString());
        userTable.put(user.getUserId(), user);
        System.out.println(
                "/user : repository - " + userTable.get(user.getUserId()));
        return user.getUserId();
    }

    public boolean isvalid(User user) {
        return userTable.containsKey(user.getUserId());
    }

    public User findById(String userId) {
        return userTable.get(userId);
    }
}