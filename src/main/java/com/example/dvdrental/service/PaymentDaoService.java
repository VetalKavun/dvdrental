package com.example.dvdrental.service;

import com.example.dvdrental.domain.Payment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentDaoService implements DaoService<Payment> {

    private JdbcTemplate jdbcTemplate;

    public PaymentDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Payment> getAll() {
        return jdbcTemplate.query("SELECT * FROM payment", (resultSet, rNum) ->
                new Payment(
                        resultSet.getInt("payment_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("staff_id"),
                        resultSet.getInt("rental_id"),
                        resultSet.getDouble("amount"),
                        resultSet.getDate("payment_date"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ));
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM payment", Integer.class);
    }

    @Override
    public Payment getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM payment WHERE payment_id = ?", (resultSet, rNum) ->
                new Payment(
                        resultSet.getInt("payment_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("staff_id"),
                        resultSet.getInt("rental_id"),
                        resultSet.getDouble("amount"),
                        resultSet.getDate("payment_date"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ), id);
    }

    @Override
    public int add(Payment item) {
        return jdbcTemplate.update("INSERT INTO payment VALUES (?, ?, ?, ?, ?, ?, ?)",
                item.getPaymentId(),
                item.getCustomerId(),
                item.getStaffId(),
                item.getRentalId(),
                item.getAmount(),
                item.getPaymentDate(),
                item.getLastUpdate());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM payment WHERE payment_id = ?", id);
    }

    @Override
    public int update(Payment item) {
        return jdbcTemplate.update("UPDATE payment SET customer_id = ?, staff_id = ?, rental_id = ?, amount = ?, payment_date = ?, last_update = ? WHERE payment_id = ?",
                item.getCustomerId(),
                item.getStaffId(),
                item.getRentalId(),
                item.getAmount(),
                item.getPaymentDate(),
                item.getLastUpdate(),
                item.getPaymentId());
    }
}
