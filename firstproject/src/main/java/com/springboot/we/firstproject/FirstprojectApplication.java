package com.springboot.we.firstproject;

import com.springboot.we.condition.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstprojectApplication implements CommandLineRunner {

	@Autowired
	private DataSourceConfig dataSourceConfig;
	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{
		System.out.println("Comman line runner...1");
		dataSourceConfig.makeConnection();
	}

}
