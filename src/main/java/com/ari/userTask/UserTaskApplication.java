package com.ari.userTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserTaskApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(UserTaskApplication.class, args);

		System.out.println("Database connection added successfully");
	}



}
