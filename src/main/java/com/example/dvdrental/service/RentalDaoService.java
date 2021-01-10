package com.example.dvdrental.service;

import com.example.dvdrental.domain.Rental;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalDaoService implements DaoService<Rental> {

    private JdbcTemplate jdbcTemplate;

    public RentalDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Rental> getAll() {
        return jdbcTemplate.query("SELECT * FROM rental", (resultSet, rNum) ->
                new Rental(
                        resultSet.getInt("rental_id"),
                        resultSet.getDate("rental_date"),
                        resultSet.getInt("inventory_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getDate("return_date"),
                        resultSet.getInt("staff_id"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ));
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM rental", Integer.class);
    }

    @Override
    public Rental getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM rental WHERE rental_id = ?", (resultSet, rNum) ->
                new Rental(
                        resultSet.getInt("rental_id"),
                        resultSet.getDate("rental_date"),
                        resultSet.getInt("inventory_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getDate("return_date"),
                        resultSet.getInt("staff_id"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ), id);
    }

    @Override
    public int add(Rental item) {
        return jdbcTemplate.update("INSERT INTO rental VALUES (?, ?, ?, ?, ?, ?, ?)",
                item.getRentalId(),
                item.getRentalDate(),
                item.getInventoryId(),
                item.getCustomerId(),
                item.getReturnDate(),
                item.getStaffId(),
                item.getLastUpdate());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM rental WHERE rental_id = ?", id);
    }

    @Override
    public int update(Rental item) {
        return jdbcTemplate.update("UPDATE rental SET rental_date = ?, inventory_id = ?, customer_id = ?, return_date = ?," +
                "staff_id = ?, last_update = ? WHERE rental_id = ?",
                item.getRentalDate(),
                item.getInventoryId(),
                item.getCustomerId(),
                item.getReturnDate(),
                item.getStaffId(),
                item.getLastUpdate(),
                item.getRentalId()
                );
    }
}
