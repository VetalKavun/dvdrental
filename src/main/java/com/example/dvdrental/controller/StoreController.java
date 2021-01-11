package com.example.dvdrental.controller;


import com.example.dvdrental.domain.Actor;
import com.example.dvdrental.domain.Store;
import com.example.dvdrental.service.DaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {

    private DaoService<Store> storeDaoService;


    public StoreController(DaoService<Store> storeDaoService) {
        this.storeDaoService = storeDaoService;
    }

    @GetMapping("list")
    public List<Store> getAllActors(){
        return storeDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return storeDaoService.count();
    }

    @GetMapping("/{id}")
    public Store getActorById(@PathVariable("id") int id){
        return storeDaoService.getById(id);
    }

    @PostMapping("add")
    public int addActor(@RequestBody Store store){
        return storeDaoService.add(store);
    }

    @DeleteMapping("/{id}")
    public int deleteActor(@PathVariable("id") int id){
        return storeDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int updateActor(@RequestBody Store store){
        return storeDaoService.update(store);
    }
}
