package com.example.dvdrental.controller;

import com.example.dvdrental.domain.Address;
import com.example.dvdrental.domain.Category;
import com.example.dvdrental.service.DaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private DaoService<Category> categoryDaoService;

    public CategoryController(DaoService<Category> daoService) {
        this.categoryDaoService = daoService;
    }

    @GetMapping("list")
    public List<Category> getAll(){
        return categoryDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return categoryDaoService.count();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable("id") int id){
        return categoryDaoService.getById(id);
    }

    @PostMapping("add")
    public int add(@RequestBody Category category){
        return categoryDaoService.add(category);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return categoryDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int update(@RequestBody Category category){
        return categoryDaoService.update(category);
    }


}
