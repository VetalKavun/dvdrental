package com.example.dvdrental.service;

import com.example.dvdrental.domain.Actor;

import java.util.List;

public interface DaoService <T>{

    List<T> getAll() ;
    int count();
    T getById(int id);
    int add(T item);
    int deleteById(int id);
    int update(T item);

}
