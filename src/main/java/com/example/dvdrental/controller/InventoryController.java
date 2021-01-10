package com.example.dvdrental.controller;

import com.example.dvdrental.domain.Actor;
import com.example.dvdrental.domain.Inventory;
import com.example.dvdrental.service.DaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    private DaoService<Inventory> inventoryDaoService;

    public InventoryController(DaoService<Inventory> inventoryDaoService) {
        this.inventoryDaoService = inventoryDaoService;
    }

    @GetMapping("list")
    public List<Inventory> getAllActors(){
        return inventoryDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return inventoryDaoService.count();
    }

    @GetMapping("/{id}")
    public Inventory getActorById(@PathVariable("id") int id){
        return inventoryDaoService.getById(id);
    }

    @PostMapping("add")
    public int addActor(@RequestBody Inventory inventory){
        return inventoryDaoService.add(inventory);
    }

    @DeleteMapping("/{id}")
    public int deleteActor(@PathVariable("id") int id){
        return inventoryDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int updateActor(@RequestBody Inventory inventory){
        return inventoryDaoService.update(inventory);
    }
}
