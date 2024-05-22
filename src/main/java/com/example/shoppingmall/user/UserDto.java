package com.example.shoppingmall.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private int id;

//    @JsonProperty("user_id")
    @NotBlank // @NotNull @NotEmpty랑 다른거
    private String userId;
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$",message = "올바른 형식을 입력하세요")
    @Email(message = "이메일 형식을 맞추도록 하세요.")
    private String email;
    private String pw;

    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$",message = "연락처를 입력하세요")
    @NotBlank(message = "연락처는 필수입력 입니다.")
    private String contact;

    public User convertToEntity(){
        return new User(id++,userId,name,email,pw,contact);
    }
}
