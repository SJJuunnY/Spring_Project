//package com.example.shoppingmall;
//
//import com.example.shoppingmall.user.User;
//import com.example.shoppingmall.user.UserJPARepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class TestMainApplication implements ApplicationRunner {
//
//    @Autowired
//    private UserJPARepository userJPARepository;
//
//    public void run(ApplicationArguments args) throws Exception{
//        Optional<User> resultUser = userJPARepository.findByUserId("songa");
//
//    }
//}