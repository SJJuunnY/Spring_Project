package com.example.shoppingmall.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
    @Id
    private int id; // PK
    private String userId;
    private String name;
    private String email;
    private String pw;
    private String contact;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
