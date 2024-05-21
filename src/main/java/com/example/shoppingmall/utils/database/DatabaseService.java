package com.example.shoppingmall.utils.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void checkConnection() {
        String sql = "SELECT 1";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
        if (result != null && result == 1) {
            System.out.println("Database connection is successful.");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}