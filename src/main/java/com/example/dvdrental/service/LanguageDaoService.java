package com.example.dvdrental.service;

import com.example.dvdrental.domain.Language;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageDaoService implements DaoService<Language> {

    private JdbcTemplate jdbcTemplate;

    public LanguageDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Language> getAll() {
        return jdbcTemplate.query("SELECT * FROM language", (resultSet, rNum) ->
                new Language(
                        resultSet.getInt("language_id"),
                        resultSet.getString("name"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ));
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM language", Integer.class);
    }

    @Override
    public Language getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM language WHERE language_id = ?", (resultSet, rNum) ->
                new Language(
                        resultSet.getInt("language_id"),
                        resultSet.getString("name"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ), id);
    }

    @Override
    public int add(Language item) {
        return jdbcTemplate.update("INSERT INTO language VALUES (?, ?, ?)",
                item.getLanguageId(),
                item.getName(),
                item.getLastUpdate());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM language WHERE language_id = ?", id);
    }

    @Override
    public int update(Language item) {
        return jdbcTemplate.update("UPDATE language SET name = ?, last_update = ? WHERE language_id = ?",
                item.getName(),
                item.getLastUpdate(),
                item.getLanguageId());
    }
}
