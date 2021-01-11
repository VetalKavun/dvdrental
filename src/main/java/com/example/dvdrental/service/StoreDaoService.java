package com.example.dvdrental.service;


import com.example.dvdrental.domain.Store;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreDaoService implements DaoService<Store>{

    private JdbcTemplate jdbcTemplate;

    public StoreDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Store> getAll() {
        return jdbcTemplate.query("SELECT * FROM store", (resultSet, rNum) ->
                new Store(
                        resultSet.getInt("store_id"),
                        resultSet.getInt("manager_staff_id"),
                        resultSet.getInt("address_id"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ));
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM store", Integer.class);
    }

    @Override
    public Store getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM store WHERE store_id = ?", (resultSet, rNum) ->
                new Store(
                        resultSet.getInt("store_id"),
                        resultSet.getInt("manager_staff_id"),
                        resultSet.getInt("address_id"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ), id);
    }

    @Override
    public int add(Store item) {
        return jdbcTemplate.update("INSERT INTO store VALUES (?, ?, ?, ?)",
                item.getStoreId(),
                item.getManagerStaffId(),
                item.getAddressId(),
                item.getLastUpdate());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM store WHERE store_id = ?", id);
    }

    @Override
    public int update(Store item) {
        return jdbcTemplate.update("UPDATE store SET manager_staff_id = ?, address_id = ?, last_update = ? WHERE store_id =?",
                item.getManagerStaffId(),
                item.getAddressId(),
                item.getLastUpdate(),
                item.getStoreId());
    }
}
