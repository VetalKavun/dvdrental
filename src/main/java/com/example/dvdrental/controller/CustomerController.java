package com.example.dvdrental.controller;

import com.example.dvdrental.domain.Country;
import com.example.dvdrental.domain.Customer;
import com.example.dvdrental.service.DaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private DaoService<Customer> customerDaoService;


    public CustomerController(DaoService<Customer> customerDaoService) {
        this.customerDaoService = customerDaoService;
    }

    @GetMapping("list")
    public List<Customer> getAll(){
        return customerDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return customerDaoService.count();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable("id") int id){
        return customerDaoService.getById(id);
    }

    @PostMapping("add")
    public int add(@RequestBody Customer customer){
        return customerDaoService.add(customer);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return customerDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int update(@RequestBody Customer customer){
        return customerDaoService.update(customer);
    }
}
