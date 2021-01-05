package com.example.dvdrental.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AddressDaoService {

    private JdbcTemplate jdbcTemplate;


    public AddressDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
