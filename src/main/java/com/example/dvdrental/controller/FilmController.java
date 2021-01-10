package com.example.dvdrental.controller;

import com.example.dvdrental.domain.Film;
import com.example.dvdrental.service.DaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("film")
public class FilmController {

    private DaoService<Film> filmDaoService;

    public FilmController(DaoService<Film> filmDaoService) {
        this.filmDaoService = filmDaoService;
    }

    @GetMapping("list")
    public List<Film> getAll(){
        return filmDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return filmDaoService.count();
    }

    @GetMapping("/{id}")
    public Film getById(@PathVariable("id") int id){
        return filmDaoService.getById(id);
    }

    @PostMapping("add")
    public int add(@RequestBody Film film){
        return filmDaoService.add(film);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return filmDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int update(@RequestBody Film film){
        return filmDaoService.update(film);
    }
}
