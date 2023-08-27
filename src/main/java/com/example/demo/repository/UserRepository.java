package com.example.demo.repository;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select * from client c where c.username =?1", nativeQuery = true)
    Optional<User> findByUsername(String username);

    @Query(value = "select * from client c where c.email =?1", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
