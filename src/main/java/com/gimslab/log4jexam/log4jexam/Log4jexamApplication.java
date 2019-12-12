package com.gimslab.log4jexam.log4jexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Log4jexamApplication {

	@Bean
	public LoggerTest getLoggerTest(){
		return new LoggerTest();
	}

	public static void main(String[] args) {
		SpringApplication.run(Log4jexamApplication.class, args);
	}

}
