package com.gimslab.log4jexam.log4jexam;

import com.gimslab.log4jexam.log4jexam.pkga.ServiceA;
import com.gimslab.log4jexam.log4jexam.pkgb.ServiceB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4jexamApplication {

	static {
		new ServiceA();
		new ServiceB();
	}

	public static void main(String[] args) {
		SpringApplication.run(Log4jexamApplication.class, args);
	}
}
