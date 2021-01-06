package com.example.dvdrental.service;

import com.example.dvdrental.domain.Actor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PropertySource("classpath:${spring.profiles.active}-queries.properties")
public class ActorDaoService implements DaoService<Actor>{

    private Environment environment;
    private JdbcTemplate jdbcTemplate;

    public ActorDaoService(JdbcTemplate jdbcTemplate, Environment environment){
        this.jdbcTemplate = jdbcTemplate;
        this.environment = environment;
    }

    @Override
    public List<Actor> getAll() {
        String query = environment.getProperty("get.all.actors");
        return jdbcTemplate.query(query, (resultSet, rNum) ->
                new Actor(resultSet.getInt("actor_id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getTimestamp("last_update").toLocalDateTime()));
    }

    @Override
    public int count() {
        String query = "SELECT COUNT(*) FROM actor";
        return jdbcTemplate.queryForObject(query,Integer.class);
    }

    @Override
    public Actor getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM actor where actor_id = ?", (resultSet, rNum) ->
                new Actor(resultSet.getInt("actor_id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getTimestamp("last_update").toLocalDateTime()), id);
    }

    @Override
    public int add(Actor actor) {
        return jdbcTemplate.update("INSERT INTO actor VALUES (?, ?, ?, ?)",
                actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getLastUpdate());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM actor WHERE actor_id = ?", id);
    }

    @Override
    public int update(Actor actor) {
        return jdbcTemplate.update("UPDATE actor SET first_name = ?, last_name = ?, last_update = ? WHERE actor_id = ?",
                actor.getFirstName(), actor.getLastName(), actor.getLastUpdate(), actor.getId());
    }
}
