package com.example.api.services.impl;

import com.example.api.domain.People;
import com.example.api.domain.dto.UserDTO;
import com.example.api.respositories.UserRepository;
import com.example.api.services.excpetions.DataIntegrateViolationException;
import com.example.api.services.excpetions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID           = 1;
    public static final String NAME          = "Eric";
    public static final String EMAIL         = "eric@mail.com";
    public static final String PASSWORD      = "123";
    public static final String OBJETO_NÃO_ENCONTRADO = "Objeto não encontrado";
    public static final int INDEX = 0;

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Mock
    private ModelMapper mapper;

    private People user;
    private UserDTO userDTO;
    private Optional<People> optionalPeople;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPeople();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(optionalPeople);

        People response = service.findById(ID);

        assertNotNull(response);

        assertEquals(People.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException(OBJETO_NÃO_ENCONTRADO));

        try{
            service.findById(ID);
        } catch (Exception ex ) {
            assertEquals(ObjectNotFoundException.class, ex .getClass());
            assertEquals(OBJETO_NÃO_ENCONTRADO, ex.getMessage());
        }
    }


    @Test
    void whenfindAllThenReturnAnListofUsers() {
        when (repository.findAll()).thenReturn(List.of(user));

        List<People> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(People.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getName());
        assertEquals(EMAIL, response.get(INDEX).getEmail());
        assertEquals(PASSWORD, response.get(INDEX).getPassword());

    }

    @Test
    void whenCreateThanReturnSuccess() {
        when(repository.save(any())).thenReturn(user);

        People response= service.create(userDTO);

        assertNotNull(response);
        assertEquals(People.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenCreateThanReturnAnDataIntegrateViolateException() {
        when(repository.findByEmail(anyString())).thenReturn(optionalPeople);

        try {
            optionalPeople.get().setId(2);
            service.create(userDTO);
        } catch (Exception ex) {
            assertEquals(DataIntegrateViolationException.class, ex.getClass());
            assertEquals("Email já cadastrado no sistema", ex.getMessage());
        }

    }

    @Test
    void whenUpdateThanReturnSuccess() {
        when(repository.save(any())).thenReturn(user);

        People response= service.update(userDTO);

        assertNotNull(response);
        assertEquals(People.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void delete() {
    }

    private void startPeople() {
        user = new People(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalPeople = Optional.of(new People(ID, NAME, EMAIL, PASSWORD));


    }
}