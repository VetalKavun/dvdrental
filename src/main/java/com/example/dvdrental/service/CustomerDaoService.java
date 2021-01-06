package com.example.dvdrental.service;

import com.example.dvdrental.domain.Customer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerDaoService implements DaoService<Customer>{

    private JdbcTemplate jdbcTemplate;
    private Environment environment;

    public CustomerDaoService(JdbcTemplate jdbcTemplate, Environment environment) {
        this.jdbcTemplate = jdbcTemplate;
        this.environment = environment;
    }


    @Override
    public List<Customer> getAll() {
        return jdbcTemplate.query("SELECT * FROM customer", (resultSet, rNum) ->
                new Customer(
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("store_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getInt("address_id"),
                        resultSet.getInt("active"),
                        resultSet.getDate("create_date"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()

                ));
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM customer", Integer.class);
    }

    @Override
    public Customer getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM customer WHERE customer_id = ?", (resultSet, rNum) ->
                new Customer(
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("store_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getInt("address_id"),
                        resultSet.getInt("active"),
                        resultSet.getDate("create_date"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()

                ),
                id);
    }

    @Override
    public int add(Customer item) {
        return jdbcTemplate.update("INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)",
                item.getCustomerId(),
                item.getStoreId(),
                item.getFirstName(),
                item.getLastName(),
                item.getEmail(),
                item.getAddressId(),
                item.getActive(),
                item.getCreateDate(),
                item.getLastUpdate());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM customer WHERE customer_id = ?", id);
    }

    @Override
    public int update(Customer item) {
        return jdbcTemplate.update("UPDATE customer SET store_id = ?, first_name = ?, last_name = ?, email = ?, " +
            "address_id = ?, active = ?, create_date = ?, last_update = ? WHERE customer_id = ?",
                item.getStoreId(),
                item.getFirstName(),
                item.getLastName(),
                item.getEmail(),
                item.getAddressId(),
                item.getActive(),
                item.getCreateDate(),
                item.getLastUpdate(),
                item.getCustomerId());
    }
}
