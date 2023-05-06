package com.example.api.services;

import com.example.api.domain.People;
import com.example.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    People findById(Integer id);
    List<People> findAll();
    People create(UserDTO obj);

}
