package com.sparta.jsonvoorhees.springapi.model.repositories;


import com.sparta.jsonvoorhees.springapi.model.entities.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {

    Optional<Schedule> findScheduleById(String id);

    List<Schedule> findSchedulesByDate(String date);
    List<Schedule> findSchedulesByMovieId(String movieId);
    List<Schedule> findSchedulesByTheaterId(String theaterId);
    
}
