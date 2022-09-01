package com.example.backend;



import com.example.backend.Data_access.ICardDAL;
import com.example.backend.Data_access.ITaskDAL;

import com.example.backend.Entities.Card;
import com.example.backend.Entities.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(ICardDAL cardDAL, ITaskDAL taskDAL) {
		return args -> {
			Card card = new Card("test");
			Card newCard = cardDAL.addCard(card);
			Task task = new Task("testTask", false, newCard);
			taskDAL.addTask(task);
		};
	}
}
