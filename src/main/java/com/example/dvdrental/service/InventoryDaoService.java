package com.example.dvdrental.service;

import com.example.dvdrental.domain.Inventory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryDaoService implements DaoService<Inventory>{

    private JdbcTemplate jdbcTemplate;

    public InventoryDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Inventory> getAll() {
        return jdbcTemplate.query("SELECT * FROM inventory", (resultSet, rNum) ->
                new Inventory(
                        resultSet.getInt("inventory_id"),
                        resultSet.getInt("film_id"),
                        resultSet.getInt("store_id"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ));
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM inventory", Integer.class);
    }

    @Override
    public Inventory getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM inventory WHERE inventory_id = ?", (resultSet, rNum) ->
                new Inventory(
                        resultSet.getInt("inventory_id"),
                        resultSet.getInt("film_id"),
                        resultSet.getInt("store_id"),
                        resultSet.getTimestamp("last_update").toLocalDateTime()
                ), id);
    }

    @Override
    public int add(Inventory item) {
        return jdbcTemplate.update("INSERT INTO inventory VALUES (?, ?, ?, ?)",
                item.getInventoryId(),
                item.getFilmId(),
                item.getStoreId(),
                item.getLastUpdate());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM inventory WHERE inventory_id = ?", id);
    }

    @Override
    public int update(Inventory item) {
        return jdbcTemplate.update("UPDATE inventory SET film_id = ?, store_id = ?, last_update = ? WHERE inventory_id = ?",
                item.getFilmId(),
                item.getStoreId(),
                item.getLastUpdate(),
                item.getInventoryId());
    }
}
