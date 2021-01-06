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

    @GetMapping("list")
    public List<Actor> getAllActors(){
        return actorDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return actorDaoService.count();
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable("id") int id){
        return actorDaoService.getById(id);
    }

    @PostMapping("add")
    public int addActor(@RequestBody Actor actor){
        return actorDaoService.add(actor);
    }

    @DeleteMapping("/{id}")
    public int deleteActor(@PathVariable("id") int id){
        return actorDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int updateActor(@RequestBody Actor actor){
        return actorDaoService.update(actor);
    }
}