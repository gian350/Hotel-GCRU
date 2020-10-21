package com.gcru.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcru.*;


@SpringBootApplication
public class HotelGcruApplication implements CommandLineRunner{

	@Autowired
	private JdbcTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(HotelGcruApplication.class, args);
		
		// hola mundo
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}

	

}
