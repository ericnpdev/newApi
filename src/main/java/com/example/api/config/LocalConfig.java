package com.example.api.config;

import com.example.api.domain.People;
import com.example.api.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;


    @Bean
    public void startDB(){
        People u1 = new People(null, "eric", "eric@mail.com", "123");
        People u2 = new People(null, "isa", "isa@mail.com", "1234");

        repository.saveAll(List.of(u1,u2));
    }

}
