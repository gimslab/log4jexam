package com.gimslab.log4jexam.log4jexam;

import ch.qos.logback.classic.Level;
import com.gimslab.log4jexam.log4jexam.pkga.ServiceA;
import com.gimslab.log4jexam.log4jexam.pkgb.ServiceB;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class LoggerLevelController {

	@GetMapping("/level")
	public List<String> allLevel() {
		return getEffectiveLevels();
	}

	@PutMapping("/logger/{loggerName}/level/{level}")
	public List<String> level(@PathVariable String loggerName, @PathVariable String level) {
		val logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(loggerName);
		logger.setLevel(Level.valueOf(level));
		return getEffectiveLevels();
	}

	private List<String> getEffectiveLevels() {
		val list = new ArrayList<String>();
		list.add(level(Logger.ROOT_LOGGER_NAME));
		list.add(level(ServiceA.class.getName()));
		list.add(level(ServiceB.class.getName()));
		return list;
	}

	private String level(String loggerName) {
		val logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(loggerName);
		return logger.getEffectiveLevel().toString();
	}
}
