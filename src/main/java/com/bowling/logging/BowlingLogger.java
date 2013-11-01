package com.bowling.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class BowlingLogger implements MethodBeforeAdvice,
		AfterReturningAdvice, ThrowsAdvice {
	
	private Logger logger;
	
	public BowlingLogger(String name) {
		logger = LoggerFactory.getLogger(name);
	}
	
	public BowlingLogger() {
		logger = LoggerFactory.getLogger(this.getClass());
	}

	public void afterThrowing(Throwable throwable) {
		logger.error(throwable.toString());
	}

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		
		logger.debug("Successfully returned from " +  arg1.getDeclaringClass() + "." + arg1.getName());
	}

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		logger.debug("Before " + arg0.getDeclaringClass() + "." + arg0.getName() + "() method is called.");
		
	}

}
