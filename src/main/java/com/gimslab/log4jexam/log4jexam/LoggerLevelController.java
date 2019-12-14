package com.gimslab.log4jexam.log4jexam;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
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

import static java.util.stream.Collectors.toList;

@RestController
@Slf4j
public class LoggerLevelController {

	@GetMapping("/loggers")
	public List<String> getLoggers(Boolean all) {
		return getAllLoggers(all == null ? false : all);
	}

	@PutMapping("/logger/{loggerName}/level/{level}")
	public List<String> level(@PathVariable String loggerName, @PathVariable String level) {
		val logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(loggerName);
		logger.setLevel(Level.valueOf(level));
		return getAllLoggers(false);
	}

	private List<String> getAllLoggers(boolean all) {
		val ctx = (LoggerContext) LoggerFactory.getILoggerFactory();
		return ctx.getLoggerList().stream()
				.filter(it -> all || it.getLevel() != null)
				.map(this::loggerToString)
				.collect(toList());
	}

	private String loggerToString(ch.qos.logback.classic.Logger logger) {
		return logger.getName() + " " + logger.getLevel() + "   " + logger.getEffectiveLevel();
	}

	private String level(String loggerName) {
		val logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(loggerName);
		return logger.getEffectiveLevel().toString();
	}
}
