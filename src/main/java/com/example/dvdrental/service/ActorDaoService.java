package com.example.dvdrental.service;

import com.example.dvdrental.domain.Actor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PropertySource("classpath:${spring.profiles.active}-queries.properties")
public class ActorDaoService {

    private Environment environment;
    private JdbcTemplate jdbcTemplate;

    public ActorDaoService(JdbcTemplate jdbcTemplate, Environment environment){
        this.jdbcTemplate = jdbcTemplate;
        this.environment = environment;
    }

    public List<Actor> getAllActors() {
        String query = environment.getProperty("get.all.actors");
        return jdbcTemplate.query(query, (resultSet, rse) ->
                new Actor(resultSet.getInt("actor_id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getTimestamp("last_update").toLocalDateTime()));

    }

    public int countActors() {
        String query = "SELECT COUNT(*) FROM actor";
        return jdbcTemplate.queryForObject(query,Integer.class);
    }

    public Actor getActorById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM actor where actor_id = ?", (resultSet, rse) ->
                new Actor(resultSet.getInt("actor_id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getTimestamp("last_update").toLocalDateTime()), id);
    }

    public int addActor(Actor actor){
        return jdbcTemplate.update("INSERT INTO actor VALUES (?, ?, ?, ?)",
                actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getLastUpdate());
    }

    public int deleteActorById(int id){
        return jdbcTemplate.update("DELETE FROM actor WHERE actor_id = ?", id);
    }

    public int updateActor(Actor actor){
        Actor newActor = getActorById(actor.getId());
        newActor.setFirstName(actor.getFirstName());
        newActor.setLastName(actor.getLastName());
        newActor.setLastUpdate(actor.getLastUpdate());
        return jdbcTemplate.update("UPDATE actor SET first_name = ?, last_name = ?, last_update = ? WHERE actor_id = ?",
                newActor.getFirstName(), newActor.getLastName(), newActor.getLastUpdate(), newActor.getId());
    }
}
