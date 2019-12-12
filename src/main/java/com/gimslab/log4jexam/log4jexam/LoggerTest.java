package com.gimslab.log4jexam.log4jexam;

import ch.qos.logback.classic.Level;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class LoggerTest {

	LoggerTest() {

		val logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		logger.setLevel(Level.ALL);

		while (true) {
			System.out.println("----------");
			log.error("ERROR");
			log.warn("WARN");
			log.info("INFO");
			log.debug("DEBUG");
			log.trace("TRACE");
			sleepsec();
		}
	}

	private void sleepsec() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
