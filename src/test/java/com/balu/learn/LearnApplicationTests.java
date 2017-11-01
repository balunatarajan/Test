package com.balu.learn;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.balu.data.Calculator;
public class LearnApplicationTests {

	Calculator c = null;
	
	@Before
	public void setUp() {
		c = new Calculator();
	}
	
	
	@Test
	public void test() {
		assertEquals(50,c.add(2, 3));
	}
	

}
