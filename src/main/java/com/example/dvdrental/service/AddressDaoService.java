package com.example.dvdrental.service;

import com.example.dvdrental.domain.Address;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressDaoService implements DaoService<Address>{

    private JdbcTemplate jdbcTemplate;
    private Environment environment;


    public AddressDaoService(JdbcTemplate jdbcTemplate, Environment environment) {
        this.jdbcTemplate = jdbcTemplate;
        this.environment = environment;
    }

    @Override
    public List<Address> getAll() {
        String query = environment.getProperty("get.all.addresses");
        return jdbcTemplate.query(query, (resultSet, rNum) ->
                        new Address(
                                resultSet.getInt("address_id"),
                                resultSet.getString("address"),
                                resultSet.getString("address2"),
                                resultSet.getString("district"),
                                resultSet.getInt("city_id"),
                                resultSet.getString("postal_code"),
                                resultSet.getString("phone"),
                                resultSet.getString("location"),
                                resultSet.getTimestamp("last_update").toLocalDateTime()
                        )
                );
    }

    @Override
    public int count() {
        String query = "SELECT COUNT(*) FROM address";
        return jdbcTemplate.queryForObject(query,Integer.class);
    }

    @Override
    public Address getById(int id) {
        String query = environment.getProperty("get.address.by.id");
        return jdbcTemplate.queryForObject(query, (resultSet, rNum) ->
                new Address(
                        resultSet.getInt("address_id"),
                        resultSet.getString("address"),
                        resultSet.getString("address2"),
                        resultSet.getString("district"),
                        resultSet.getInt("city_id"),
                        resultSet.getString("postal_code"),
                        resultSet.getString("phone"),
                        resultSet.getString("location"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ), id
        );
    }

    @Override
    public int add(Address item) {
        String query = environment.getProperty("add.address");
        return jdbcTemplate.update(query,
                item.getAddressId(),
                item.getAddress(),
                item.getAddress2(),
                item.getDistrict(),
                item.getCityId(),
                item.getPostalCode(),
                item.getPhone(),
                item.getLocation(),
                item.getLastUpdate()
        );
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM address WHERE address_id = ?", id);
    }

    @Override
    public int update(Address item) {
        String query = environment.getProperty("update.address");
        return jdbcTemplate.update(query, item.getAddress(), item.getAddress2(),
            item.getDistrict(), item.getCityId(), item.getPostalCode(), item.getPhone(), item.getLocation(), item.getLastUpdate(), item.getAddressId());
    }
}
