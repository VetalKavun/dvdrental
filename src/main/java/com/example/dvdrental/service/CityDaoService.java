package com.example.dvdrental.service;

import com.example.dvdrental.domain.City;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityDaoService implements DaoService<City>{

    private JdbcTemplate jdbcTemplate;
    private Environment environment;

    public CityDaoService(JdbcTemplate jdbcTemplate, Environment environment) {
        this.jdbcTemplate = jdbcTemplate;
        this.environment = environment;
    }

    @Override
    public List<City> getAll() {
        return jdbcTemplate.query("SELECT * FROM city", (resultSet, rNum) ->
                new City(
                    resultSet.getInt("city_id"),
                    resultSet.getString("city"),
                    resultSet.getInt("country_id"),
                    resultSet.getTimestamp("last_update").toLocalDateTime()
                ));
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM city", Integer.class);
    }

    @Override
    public City getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM city WHERE city_id = ?", (resultSet, rNum) ->
                new City(
                        resultSet.getInt("city_id"),
                        resultSet.getString("city"),
                        resultSet.getInt("country_id"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ),
                id);
    }

    @Override
    public int add(City item) {
        return jdbcTemplate.update("INSERT INTO city VALUES (?, ?, ?, ?)",
                item.getCityId(), item.getCity(), item.getCountryId(), item.getLastUpdate());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM city WHERE city_id = ?", id);
    }

    @Override
    public int update(City item) {
        return jdbcTemplate.update("UPDATE city SET city = ?, country_id = ?, last_update = ? WHERE city_id = ?",
                item.getCity(), item.getCountryId(), item.getLastUpdate(), item.getCityId());
    }
}
