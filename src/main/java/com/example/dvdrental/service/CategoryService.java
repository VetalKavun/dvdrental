package com.example.dvdrental.service;

import com.example.dvdrental.domain.Category;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements DaoService<Category>{

    private JdbcTemplate jdbcTemplate;
    private Environment environment;

    public CategoryService(JdbcTemplate jdbcTemplate, Environment environment) {
        this.jdbcTemplate = jdbcTemplate;
        this.environment = environment;
    }


    @Override
    public List<Category> getAll() {
        return jdbcTemplate.query("SELECT * FROM category", (resultSet, rNum) ->
                new Category(
                        resultSet.getInt("category_id"),
                        resultSet.getString("name"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ));
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM category", Integer.class);
    }

    @Override
    public Category getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM category WHERE category_id = ?", (resultSet, rNum) ->
                new Category(
                        resultSet.getInt("category_id"),
                        resultSet.getString("name"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ), id);
    }

    @Override
    public int add(Category item) {
        return jdbcTemplate.update("INSERT INTO category VALUES (?, ?, ?)",
                item.getCategoryId(),
                item.getName(),
                item.getLastUpdate()
        );
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM category WHERE category_id = ?", id);
    }

    @Override
    public int update(Category item) {
        return jdbcTemplate.update("UPDATE category SET name = ?, last_update = ? WHERE category_id = ?", item.getName(), item.getLastUpdate(), item.getCategoryId());
    }
}
