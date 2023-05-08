package com.example.api.services.impl;

import com.example.api.domain.People;
import com.example.api.domain.dto.UserDTO;
import com.example.api.respositories.UserRepository;
import com.example.api.services.UserService;
import com.example.api.services.excpetions.DataIntegrateViolationException;
import com.example.api.services.excpetions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public People findById(Integer id) {
        Optional<People> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @GetMapping
    public List<People> findAll() {
       return repository.findAll();

    }

    @Override
    public People create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, People.class));
    }

    @Override
    public People update(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, People.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    private void findByEmail(UserDTO obj) {
        Optional<People> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId())) {
            throw new DataIntegrateViolationException("Email já cadastrado no sistema");
        }

    }



}
