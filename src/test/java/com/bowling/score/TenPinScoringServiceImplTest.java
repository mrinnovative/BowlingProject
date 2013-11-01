package com.bowling.score;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class TenPinScoringServiceImplTest {

    @Test
	public void testClearScore() {
        String SPRING_CONFIG = "ScoringService.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG);
		ScoringService ss = (ScoringService)ctx.getBean("ten_pin_scoring_system");
		ss.clearScore();
		assertEquals(0, ss.getFinalScore());
	}
}
