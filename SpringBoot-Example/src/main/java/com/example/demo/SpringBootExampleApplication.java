package com.example.demo;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;
import static java.lang.System.exit;

@SpringBootApplication
public class SpringBootExampleApplication implements CommandLineRunner{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	@Transactional(readOnly = true)
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("\n1.findAll()...");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		
		exit(0);
	}
}
