package com.example.dvdrental.service;

import com.example.dvdrental.domain.Film;
import com.example.dvdrental.domain.Rating;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
                        resultSet.getString("special_features"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ));
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM film", Integer.class);
    }

    @Override
    public Film getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM film WHERE film_id = ?", (resultSet, rNum) ->
                new Film(
                        resultSet.getInt("film_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        String.valueOf(resultSet.getDate("release_year").toLocalDate().getYear()),
                        resultSet.getInt("language_id"),
                        resultSet.getInt("original_language_id"),
                        resultSet.getInt("rental_duration"),
                        resultSet.getDouble("rental_rate"),
                        resultSet.getInt("length"),
                        resultSet.getDouble("replacement_cost"),
                        resultSet.getString("rating"),
                        resultSet.getString("special_features"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ), id);
    }

    @Override
    public int add(Film item) {
        return jdbcTemplate.update("INSERT INTO film VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                item.getFilmID(),
                item.getTitle(),
                item.getDescription(),
                item.getReleaseYear(),
                item.getLanguageId(),
                item.getOriginalLanguageId(),
                item.getRentalDuration(),
                item.getRentalRate(),
                item.getLength(),
                item.getReplacementCost(),
                item.getRating(),
                item.getSpecialFeatures(),
                item.getLastUpdate()
        );
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM film WHERE film_id = ?", id);
    }

    @Override
    public int update(Film item) {
        return jdbcTemplate.update("UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, original_language_id = ?, " +
                        "rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, special_features = ?, " +
                        "last_update = ? WHERE film_id = ?",
                item.getTitle(),
                item.getDescription(),
                item.getReleaseYear(),
                item.getLanguageId(),
                item.getOriginalLanguageId(),
                item.getRentalDuration(),
                item.getRentalRate(),
                item.getLength(),
                item.getReplacementCost(),
                item.getRating(),
                item.getSpecialFeatures(),
                item.getLastUpdate(),
                item.getFilmID()
                );
    }
}
