package com.example.api.domain;

import jakarta.persistence.*;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;



    @Column (unique = true)
    private String email;
    private String password;


}

