package com.gimslab.logbackexam.dynamiclevelchange;

import com.gimslab.logbackexam.dynamiclevelchange.pkga.ServiceA;
import com.gimslab.logbackexam.dynamiclevelchange.pkgb.ServiceB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogbackDynamicLevelChangeApplication {

	static {
		new ServiceA();
		new ServiceB();
	}

	public static void main(String[] args) {
		SpringApplication.run(LogbackDynamicLevelChangeApplication.class, args);
	}
}
