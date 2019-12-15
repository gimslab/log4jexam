package com.gimslab.logbackexam.dynamiclevelchange;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

@RestController
@Slf4j
public class LoggerLevelController {

	@GetMapping("/loggers")
	public String getLoggers(String all, String testLog) {
		if (trueIfNotNull(testLog))
						testLog();
		return getAllLoggers(
						trueIfNotNull(all));
	}

	@PutMapping("/loggers/{loggerName}/level/{level}")
	public String updateLoggerLevel(@PathVariable String loggerName, @PathVariable String level) {
		getLoggerByName(loggerName)
				.setLevel(Level.valueOf(level));
		return getAllLoggers(false);
	}

	@DeleteMapping("/loggers/{loggerName}/level")
	public String deleteLogger(@PathVariable String loggerName) {
		getLoggerByName(loggerName)
				.setLevel(null);
		return getAllLoggers(false);
	}

	private Logger getLoggerByName(@PathVariable String loggerName) {
		return (Logger) LoggerFactory.getLogger(loggerName);
	}

	private String getAllLoggers(boolean all) {
		val ctx = (LoggerContext) LoggerFactory.getILoggerFactory();
		return ctx.getLoggerList().stream()
								.filter(it -> all || it.getLevel() != null)
								.map(this::loggerToString)
								.collect(joining(lineSeparator()));
	}

	private String loggerToString(ch.qos.logback.classic.Logger logger) {
		return logger.getName() + " " + logger.getLevel() + "   " + logger.getEffectiveLevel();
	}

	private void testLog() {
		String s = "+++ TEST_LOG {} +++";
		log.error(s, "ERROR");
		log.warn(s, "WARN");
		log.info(s, "INFO");
		log.debug(s, "DEBUG");
		log.trace(s, "TRACE");
	}

	private boolean trueIfNotNull(Object o) {
		return o != null;
	}
}
