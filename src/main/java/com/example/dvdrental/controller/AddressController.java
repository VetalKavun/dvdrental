package com.example.dvdrental.controller;

import com.example.dvdrental.domain.Address;
import com.example.dvdrental.service.DaoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    private DaoService<Address> addressDaoService;

    public AddressController(DaoService<Address> daoService) {
        this.addressDaoService = daoService;
    }


    @GetMapping("list")
    public List<Address> getAll(){
        return addressDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return addressDaoService.count();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable("id") int id){
        return addressDaoService.getById(id);
    }

    @PostMapping("add")
    public int add(@RequestBody Address actor){
        return addressDaoService.add(actor);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return addressDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int update(@RequestBody Address address){
        return addressDaoService.update(address);
    }
}
