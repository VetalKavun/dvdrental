package com.example.dvdrental.controller;

import com.example.dvdrental.domain.Film;
import com.example.dvdrental.service.DaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("film")
public class FilmController {

    private DaoService<Film> filmDaoService;

    public FilmController(DaoService<Film> filmDaoService) {
        this.filmDaoService = filmDaoService;
    }

    @GetMapping("/list")
    public List<Film> getAll(){
        return filmDaoService.getAll();
    }
}
