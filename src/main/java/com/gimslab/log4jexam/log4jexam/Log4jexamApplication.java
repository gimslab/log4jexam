package com.gimslab.log4jexam.log4jexam;

import ch.qos.logback.classic.Level;
import com.gimslab.log4jexam.log4jexam.pkga.ServiceA;
import com.gimslab.log4jexam.log4jexam.pkgb.ServiceB;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Log4jexamApplication {

	public static void main(String[] args) {
		SpringApplication.run(Log4jexamApplication.class, args);
	}

	@Bean
	public ServiceA getServiceA(){
		return new ServiceA();
	}

	@Bean
	public ServiceB getServiceB(){
		return new ServiceB();
	}
}
