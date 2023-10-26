package com.sparta.jsonvoorhees.springapi.model.repositories;


import com.sparta.jsonvoorhees.springapi.model.entities.Theater;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheaterRepository extends MongoRepository<Theater, String> {

    Optional<Theater> findTheaterById(String id);
    Optional<Theater> findTheaterByLocation(String location);
    Optional<Theater> findTheaterByTheaterId(Long id);
    List<Theater> findTheatersByLocationAddressCityContainsIgnoreCase(String city);
    Page<Theater> findTheatersByLocationAddressCityContainsIgnoreCase(String city, Pageable pageable);

}
