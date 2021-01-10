package com.example.dvdrental.controller;

import com.example.dvdrental.domain.Actor;
import com.example.dvdrental.domain.Payment;
import com.example.dvdrental.service.DaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment")
public class PaymentController {

    private DaoService<Payment> paymentDaoService;

    public PaymentController(DaoService<Payment> paymentDaoService) {
        this.paymentDaoService = paymentDaoService;
    }

    @GetMapping("list")
    public List<Payment> getAllActors(){
        return paymentDaoService.getAll();
    }

    @GetMapping("count")
    public int countActors(){
        return paymentDaoService.count();
    }

    @GetMapping("/{id}")
    public Payment getActorById(@PathVariable("id") int id){
        return paymentDaoService.getById(id);
    }

    @PostMapping("add")
    public int addActor(@RequestBody Payment payment){
        return paymentDaoService.add(payment);
    }

    @DeleteMapping("/{id}")
    public int deleteActor(@PathVariable("id") int id){
        return paymentDaoService.deleteById(id);
    }

    @PostMapping("update")
    public int updateActor(@RequestBody Payment payment){
        return paymentDaoService.update(payment);
    }

}
