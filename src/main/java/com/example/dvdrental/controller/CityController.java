package com.example.dvdrental.controller;

import com.example.dvdrental.domain.Category;
import com.example.dvdrental.domain.City;
import com.example.dvdrental.service.DaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("city")
public class CityController {

    private DaoService<City> cityDaoService;

    public CityController(DaoService<City> cityDaoService) {
        this.cityDaoService = cityDaoService;
    }

    @GetMapping("list")
    public List<City> getAll(){
        return cityDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return cityDaoService.count();
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable("id") int id){
        return cityDaoService.getById(id);
    }

    @PostMapping("add")
    public int add(@RequestBody City city){
        return cityDaoService.add(city);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return cityDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int update(@RequestBody City city){
        return cityDaoService.update(city);
    }
}
