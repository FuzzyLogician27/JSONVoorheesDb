package com.sparta.jsonvoorhees.springapi.model.repositories;

import com.sparta.jsonvoorhees.springapi.model.entities.RoleUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleUserRepository extends MongoRepository<RoleUser, Long> {

    Optional<RoleUser> findRoleUserByUserName(String username);
}
