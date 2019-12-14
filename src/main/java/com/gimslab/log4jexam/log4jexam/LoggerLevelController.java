package com.gimslab.log4jexam.log4jexam;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
	public List<String> updateLoggerLevel(@PathVariable String loggerName, @PathVariable String level) {
		getLoggerByName(loggerName)
				.setLevel(Level.valueOf(level));
		return getAllLoggers(false);
	}

	@DeleteMapping("/logger/{loggerName}")
	public List<String> deleteLogger(@PathVariable String loggerName){
		getLoggerByName(loggerName)
				.setLevel(null);
		return getAllLoggers(false);
	}

	private Logger getLoggerByName(@PathVariable String loggerName) {
		return (Logger) LoggerFactory.getLogger(loggerName);
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
}
