package com.example.dvdrental.controller;

import com.example.dvdrental.domain.Actor;
import com.example.dvdrental.domain.Language;
import com.example.dvdrental.service.DaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("language")
public class LanguageController {

    private DaoService<Language> languageDaoService;

    public LanguageController(DaoService<Language> languageDaoService) {
        this.languageDaoService = languageDaoService;
    }

    @GetMapping("list")
    public List<Language> getAllActors(){
        return languageDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return languageDaoService.count();
    }

    @GetMapping("/{id}")
    public Language getActorById(@PathVariable("id") int id){
        return languageDaoService.getById(id);
    }

    @PostMapping("add")
    public int addActor(@RequestBody Language language){
        return languageDaoService.add(language);
    }

    @DeleteMapping("/{id}")
    public int deleteActor(@PathVariable("id") int id){
        return languageDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int updateActor(@RequestBody Language language){
        return languageDaoService.update(language);
    }
}
