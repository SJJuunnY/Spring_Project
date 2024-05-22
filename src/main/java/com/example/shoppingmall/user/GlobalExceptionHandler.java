package com.example.shoppingmall.user;

import com.example.shoppingmall.utils.ApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import static com.example.shoppingmall.utils.ApiUtils.error;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(MethodArgumentNotValidException.class)//매개변수에 있으면 안넣어줘도 된다
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiUtils.ApiResult<Map<String, String>> handleValidationException(MethodArgumentNotValidException errors){
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