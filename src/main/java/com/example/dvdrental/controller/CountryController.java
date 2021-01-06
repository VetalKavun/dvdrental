package com.example.dvdrental.controller;

import com.example.dvdrental.domain.City;
import com.example.dvdrental.domain.Country;
import com.example.dvdrental.service.DaoService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("country")
public class CountryController {

    private DaoService<Country> countryDaoService;
    private Environment environment;

    public CountryController(DaoService<Country> countryDaoService, Environment environment) {
        this.countryDaoService = countryDaoService;
        this.environment = environment;
    }

    @GetMapping("list")
    public List<Country> getAll(){
        return countryDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return countryDaoService.count();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable("id") int id){
        return countryDaoService.getById(id);
    }

    @PostMapping("add")
    public int add(@RequestBody Country country){
        return countryDaoService.add(country);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return countryDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int update(@RequestBody Country country){
        return countryDaoService.update(country);
    }
}
