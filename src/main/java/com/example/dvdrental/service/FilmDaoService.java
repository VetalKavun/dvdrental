package com.example.dvdrental.service;

import com.example.dvdrental.domain.Film;
import com.example.dvdrental.domain.Rating;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmDaoService implements DaoService<Film>{

    private JdbcTemplate jdbcTemplate;

    public FilmDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Film> getAll() {
        return jdbcTemplate.query("SELECT * FROM film", (resultSet, rNum) ->
                new Film(
                        resultSet.getInt("film_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("release_year"),
                        resultSet.getInt("language_id"),
                        resultSet.getInt("original_language_id"),
                        resultSet.getInt("rental_duration"),
                        resultSet.getDouble("rental_rate"),
                        resultSet.getInt("length"),
                        resultSet.getDouble("replacement_cost"),
                        resultSet.getString("rating"),
                        resultSet.getString("special_features")
                ));
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Film getById(int id) {
        return null;
    }

    @Override
    public int add(Film item) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public int update(Film item) {
        return 0;
    }
}
