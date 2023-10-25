package com.sparta.jsonvoorhees.springapi.service;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ApiLibraryServiceTests {
    @Autowired
    private ApiLibraryService testService;

    @Test
    public void getAllFilms()
    {
        assertNotNull(testService.getMovieRepository().findAll());
    }
}
