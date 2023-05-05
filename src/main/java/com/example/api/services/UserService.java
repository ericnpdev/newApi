package com.example.api.services;

import com.example.api.domain.People;

import java.util.List;

public interface UserService {

    People findById(Integer id);
    List<People> findAll();

}
