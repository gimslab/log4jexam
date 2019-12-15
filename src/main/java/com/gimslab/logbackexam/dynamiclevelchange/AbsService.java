package com.gimslab.logbackexam.dynamiclevelchange;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
public abstract class AbsService {

	public void testLog() {
		System.out.println("----------");
		logger().error("ERROR");
		logger().warn("WARN");
		logger().info("INFO");
		logger().debug("DEBUG");
		logger().trace("TRACE");
	}

	protected abstract Logger logger();
}
