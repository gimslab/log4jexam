package com.gimslab.logbackexam.dynamiclevelchange.pkga;

import com.gimslab.logbackexam.dynamiclevelchange.AbsService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ServiceA extends AbsService {

	@Override
	protected Logger logger() {
		return log;
	}

	@Scheduled(fixedDelay = 3000)
	public void testLog(){
		super.testLog();
	}
}
