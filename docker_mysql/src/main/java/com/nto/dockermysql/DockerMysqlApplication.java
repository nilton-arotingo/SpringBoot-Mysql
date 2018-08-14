package com.nto.dockermysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nto.dockermysql.config.AppConfigProperties;

@SpringBootApplication
public class DockerMysqlApplication implements CommandLineRunner {
	
	@Autowired
	AppConfigProperties appConfigProperties;

	public static void main(String[] args) {
		SpringApplication.run(DockerMysqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(appConfigProperties.toString());
		
	}
	
	
}
