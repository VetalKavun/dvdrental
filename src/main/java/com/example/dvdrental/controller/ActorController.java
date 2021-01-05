package com.example.dvdrental.controller;

import com.example.dvdrental.service.ActorDaoService;
import com.example.dvdrental.domain.Actor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("actor")
public class ActorController {

    private ActorDaoService actorDaoService;

    public ActorController(ActorDaoService daoService){
        this.actorDaoService = daoService;
    }

    @GetMapping("actor_list")
    public List<Actor> getAllActors(){
        return actorDaoService.getAllActors();
    }

    @GetMapping("count_actors")
    public int countActors(){
        return actorDaoService.countActors();
    }

    @GetMapping("actor/{id}")
    public Actor getActorById(@PathVariable("id") int id){
        return actorDaoService.getActorById(id);
    }

    @PostMapping("add")
    public int addActor(@RequestBody Actor actor){
        return actorDaoService.addActor(actor);
    }

    @DeleteMapping("delete/{id}")
    public int deleteActor(@PathVariable("id") int id){
        return actorDaoService.deleteActorById(id);
    }

    @PostMapping("update")
    public int updateActor(@RequestBody Actor actor){
        return actorDaoService.updateActor(actor);
    }
}