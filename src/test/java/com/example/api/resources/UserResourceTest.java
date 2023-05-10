package com.example.api.resources;

import com.example.api.domain.People;
import com.example.api.domain.dto.UserDTO;
import com.example.api.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class UserResourceTest {

    public static final Integer ID           = 1;
    public static final String NAME          = "Eric";
    public static final String EMAIL         = "eric@mail.com";
    public static final String PASSWORD      = "123";
    public static final int INDEX = 0;

    private People user;
    private UserDTO userDTO;


    @InjectMocks
    private UserResource resource;

    @Mock
    private UserServiceImpl service;

    @Mock
    private ModelMapper mapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPeople();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }



    private void startPeople() {
        user = new People(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }

}

