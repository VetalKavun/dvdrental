package com.example.dvdrental.service;

import com.example.dvdrental.domain.Staff;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffDaoService implements DaoService<Staff>{

    private JdbcTemplate jdbcTemplate;

    public StaffDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Staff> getAll() {
        return jdbcTemplate.query("SELECT * FROM staff", (resultSet, rNum) ->
                new Staff(
                        resultSet.getInt("staff_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("address_id"),
                        resultSet.getBytes("picture"),
                        resultSet.getString("email"),
                        resultSet.getInt("store_id"),
                        resultSet.getInt("active"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ));
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM staff", Integer.class);
    }

    @Override
    public Staff getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM staff WHERE staff_id = ?", (resultSet, rNum) ->
                new Staff(
                        resultSet.getInt("staff_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("address_id"),
                        resultSet.getBytes("picture"),
                        resultSet.getString("email"),
                        resultSet.getInt("store_id"),
                        resultSet.getInt("active"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ), id);
    }

    @Override
    public int add(Staff item) {
        return jdbcTemplate.update("INSERT INTO staff VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                item.getStaffId(),
                item.getFirstName(),
                item.getLastName(),
                item.getAddressId(),
                item.getPicture(),
                item.getEmail(),
                item.getStoreId(),
                item.isActive(),
                item.getUserName(),
                item.getPassword(),
                item.getLastUpdate());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM staff WHERE staff_id = ?", id);
    }

    @Override
    public int update(Staff item) {
        return jdbcTemplate.update("UPDATE staff SET first_name = ? , last_name = ?, address_id = ?, " +
                "picture = ?, email = ?, store_id = ?, active = ?, username = ?, password = ?," +
                "last_update = ? WHERE staff_id = ?",
                item.getFirstName(),
                item.getLastName(),
                item.getAddressId(),
                item.getPicture(),
                item.getEmail(),
                item.getStoreId(),
                item.isActive(),
                item.getUserName(),
                item.getPassword(),
                item.getLastUpdate(),
                item.getStaffId());
    }
}
