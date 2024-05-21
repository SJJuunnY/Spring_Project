package com.example.shoppingmall.product.user;


//import com.example.shoppingmall.utils.database.DatabaseService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;

//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    Map<String,User> userTable = new HashMap<>();

//    @Autowired
//    EntityManager entityManager; //넣어주세요~ 하면

//    public String save(User user){
//        entityManager.persist(user);
//        User savedUser = entityManager.find(User.class, user.getId());
//        System.out.println(savedUser.toString());
//        return savedUser.toString();
//    }
//    public User find(int userId){
//        User findUser = entityManager.find(User.class, userId);
//        return findUser;
//    }

//    @Autowired
//    DataSource dataSource;


//
//    public void makeConnection() {
//        try{
//            connection = dataSource.getConnection();
//            System.out.println("연결 성공띠");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

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