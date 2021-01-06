package com.example.dvdrental.service;

import com.example.dvdrental.domain.Country;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryDaoService implements DaoService<Country>{

    private JdbcTemplate jdbcTemplate;
    private Environment environment;

    public CountryDaoService(JdbcTemplate jdbcTemplate, Environment environment) {
        this.jdbcTemplate = jdbcTemplate;
        this.environment = environment;
    }

    @Override
    public List<Country> getAll() {
        return jdbcTemplate.query("SELECT * FROM country", (resultSet, rNum) ->
                new Country(
                        resultSet.getInt("country_id"),
                        resultSet.getString("country"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ));
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM country", Integer.class);
    }

    @Override
    public Country getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM country WHERE country_id = ?", (resultSet, rNum) ->
                new Country(
                        resultSet.getInt("country_id"),
                        resultSet.getString("country"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ),
                id);
    }

    @Override
    public int add(Country item) {
        return jdbcTemplate.update("INSERT INTO country VALUES (?, ?, ?)",
                item.getCountryId(),
                item.getCountry(),
                item.getLastUpdate());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM country WHERE country_id = ?", id);
    }

    @Override
    public int update(Country item) {
        return jdbcTemplate.update("UPDATE country SET country = ?, last_update = ? WHERE country_id = ?",
                item.getCountry(),
                item.getLastUpdate(),
                item.getCountryId());
    }
}
