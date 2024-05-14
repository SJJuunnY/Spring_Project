package com.example.shoppingmall.product.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
    private String name;
    private String email;
    private String userId;
    private String pw;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userId='" + userId + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
