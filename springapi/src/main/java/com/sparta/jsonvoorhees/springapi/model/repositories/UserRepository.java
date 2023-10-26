package com.sparta.jsonvoorhees.springapi.model.repositories;


import com.sparta.jsonvoorhees.springapi.model.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserById(String id);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByName(String name);

    List<User> findUsersByNameContainingIgnoreCase(String name);
    Page<User> findUsersByNameContainingIgnoreCase(String name, Pageable pageable);

}
