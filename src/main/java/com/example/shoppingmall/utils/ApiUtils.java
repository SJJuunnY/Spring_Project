package com.example.shoppingmall.utils;

import com.fasterxml.jackson.core.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;
public class ApiUtils<T> {
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult(true, data, null);
    }

    public static <T> ApiResult<T> error(T message, HttpStatus httpStatus) {
        return new ApiResult(false,
                null,
                new ApiError(message, httpStatus));
    }

    @Getter
    @AllArgsConstructor
    public static class ApiResult<T> {

        boolean success;
        T response;
        ApiError error;
    }

    @Getter
    static class ApiError<T> {
        T message;
        HttpStatus httpStatus;

        ApiError(T message, HttpStatus httpStatus) {
            this.message = message;
            this.httpStatus = httpStatus;
        }
    }
}


