package com.example.api.services.impl;

import com.example.api.domain.People;
import com.example.api.respositories.UserRepository;
import com.example.api.services.UserService;
import com.example.api.services.excpetions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public People findById(Integer id) {
        Optional<People> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @GetMapping
    public List<People> findAll() {
       return repository.findAll();

    }

    }
