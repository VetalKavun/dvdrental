package com.example.dvdrental.controller;

import com.example.dvdrental.domain.Actor;
import com.example.dvdrental.domain.Staff;
import com.example.dvdrental.service.DaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("staff")
public class StaffController {

    private DaoService<Staff> staffDaoService;

    public StaffController(DaoService<Staff> staffDaoService) {
        this.staffDaoService = staffDaoService;
    }

    @GetMapping("list")
    public List<Staff> getAllActors(){
        return staffDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return staffDaoService.count();
    }

    @GetMapping("/{id}")
    public Staff getActorById(@PathVariable("id") int id){
        return staffDaoService.getById(id);
    }

    @PostMapping("add")
    public int addActor(@RequestBody Staff staff){
        return staffDaoService.add(staff);
    }

    @DeleteMapping("/{id}")
    public int deleteActor(@PathVariable("id") int id){
        return staffDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int updateActor(@RequestBody Staff staff){
        return staffDaoService.update(staff);
    }
}
