package com.bowling.frame;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


public class FrameServiceImplTest {
	
	private String SPRING_CONFIG = "GameService.xml";
	
	@Test
	public void testConstructors() {
		FrameServiceImpl fs = new FrameServiceImpl(1, new String[]{"7","/"});
		assertEquals(1, fs.getFRAME_NO());
		assertArrayEquals(new String[]{"7","/"}, fs.getFrameArray());
	}
	
	@Test
	public void testConstructors2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG);
		FrameService fs = (FrameService)ctx.getBean("frame");
		assertEquals(2, fs.getMAX_NUM_OF_ROLLS());
	}
	
	@Test
	public void testInit() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG);
		FrameService fs = (FrameService)ctx.getBean("frame");		
		assertTrue(fs.isValid() );
	}
	
	@Test
	public void testToString() {
		FrameServiceImpl fs = new FrameServiceImpl(1, new String[]{"3","6"});
		assertEquals("Message","1->36", fs.toString());
	}
	
	@Test
	public void testGetAllRolls() {
		FrameServiceImpl fs = new FrameServiceImpl(1, new String[]{"9","/"});		
		assertArrayEquals("Message", new String[]{"9","/"},fs.getAllRolls());
	}
	
	@Test
	public void testGetRoll() {
		FrameServiceImpl fs = new FrameServiceImpl(1, new String[]{"6","1"});		
		assertEquals("Message", "6",fs.getRoll(1));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetRollError() {
		FrameServiceImpl fs = new FrameServiceImpl(1, new String[]{"6","1"});		
		assertEquals("Message", "6",fs.getRoll(7));
	}
	
	@Test
	public void testMaxNumOfRolls() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG);
		FrameService fs = (FrameService)ctx.getBean("frame");
		fs.setMAX_NUM_OF_ROLLS(5);
		assertEquals(5, fs.getMAX_NUM_OF_ROLLS());
	}
	
	@Test
	public void testFrameNum() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG);
		FrameService fs = (FrameService)ctx.getBean("frame");
		fs.setFRAME_NO(5);
		assertEquals(5, fs.getFRAME_NO());
	}
}
