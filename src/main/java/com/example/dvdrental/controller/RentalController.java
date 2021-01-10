package com.example.dvdrental.controller;

import com.example.dvdrental.domain.Actor;
import com.example.dvdrental.domain.Rental;
import com.example.dvdrental.service.DaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rental")
public class RentalController {

    private DaoService<Rental> rentalDaoService;

    public RentalController(DaoService<Rental> rentalDaoService) {
        this.rentalDaoService = rentalDaoService;
    }

    @GetMapping("list")
    public List<Rental> getAllActors(){
        return rentalDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return rentalDaoService.count();
    }

    @GetMapping("/{id}")
    public Rental getActorById(@PathVariable("id") int id){
        return rentalDaoService.getById(id);
    }

    @PostMapping("add")
    public int addActor(@RequestBody Rental rental){
        return rentalDaoService.add(rental);
    }

    @DeleteMapping("/{id}")
    public int deleteActor(@PathVariable("id") int id){
        return rentalDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int updateActor(@RequestBody Rental rental){
        return rentalDaoService.update(rental);
    }

}
