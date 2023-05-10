package com.example.api.respositories;

import com.example.api.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <People, Integer> {

    Optional<People> findByEmail(String email);


}
