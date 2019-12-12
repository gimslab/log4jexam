package com.gimslab.log4jexam.log4jexam;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
public abstract class AbsService {

	public void testLog() {
		System.out.println("----------");
		loger().error("ERROR");
		loger().warn("WARN");
		loger().info("INFO");
		loger().debug("DEBUG");
		loger().trace("TRACE");
	}

	protected abstract Logger loger();
}
