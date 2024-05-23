package com.example.shoppingmall.user;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
@Transactional
public class UserRepository {
    Map<String,User> userTable = new HashMap<>();
    int id = 0;

    @Autowired
    EntityManager entityManager; //넣어주세요~ 하면

    public String save(User user){
        entityManager.persist(user);
//        user.setId(id++);
        System.out.println("UserRepo : "+user.toString());
        User savedUser = entityManager.find(User.class, user.getId());
        System.out.println(savedUser.toString());
        return savedUser.toString();
    }
    public User findById(int id){
//        User findUser = entityManager.find(User.class, userId); //반환타입이 맴버
        System.out.println("UserRepo findById : "+id);
        return entityManager.find(User.class, id);
    }

    @Autowired
    DataSource dataSource;

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