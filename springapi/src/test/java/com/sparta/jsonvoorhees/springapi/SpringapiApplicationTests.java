package com.sparta.jsonvoorhees.springapi;

import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.repositories.CommentRepository;
import com.sparta.jsonvoorhees.springapi.model.repositories.MovieRepository;
import com.sparta.jsonvoorhees.springapi.model.repositories.ScheduleRepository;
import com.sparta.jsonvoorhees.springapi.model.repositories.TheaterRepository;
import com.sparta.jsonvoorhees.springapi.service.VoorheesWebService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
class SpringapiApplicationTests {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	private CommentRepository commentRepository;

	@MockBean
	private MovieRepository movieRepository;

	@MockBean
	private ScheduleRepository scheduleRepository;

	@MockBean
	private TheaterRepository theaterRepository;

	@MockBean
	private VoorheesWebService voorheesWebService;

	public void returnAllUsers() {

	}

	@Test  @DisplayName("Test page")
	void testPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/web/home")).andDo(MockMvcResultHandlers.print());
	}

	@Test
	@DisplayName("test films page")
	void testFilmsPage() throws Exception {
		Movie movie = new Movie();
		movie.setId("1");
		movie.setTitle("Best Film Ever");
		Mockito.when(movieRepository.findAll()).thenReturn(new ArrayList<>(List.of(movie)));

		mockMvc.perform(MockMvcRequestBuilders.get("/web/movies")).andDo(MockMvcResultHandlers.print());
	}

}
