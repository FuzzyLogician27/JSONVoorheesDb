package com.sparta.jsonvoorhees.springapi;

import com.sparta.jsonvoorhees.springapi.model.entities.RoleUser;
import com.sparta.jsonvoorhees.springapi.model.repositories.RoleUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringapiApplication.class, args);

	}
	
//	@Bean
//	CommandLineRunner runner(RoleUserRepository roleUserRepository, PasswordEncoder passwordEncoder) {
//		return args -> {
//			roleUserRepository.save(new RoleUser("user", passwordEncoder.encode("password"), "ROLE_USER"));
//			roleUserRepository.save(new RoleUser("admin", passwordEncoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
//		};
//	}

}
