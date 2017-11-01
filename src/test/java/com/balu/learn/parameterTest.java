package com.balu.learn;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.balu.data.Calculator;

@RunWith(Parameterized.class)
public class parameterTest {
	private Integer inputNumber;
    private Boolean expectedResult;
	Calculator c;

	 @Before
	   public void initialize() {
	      c = new Calculator();
	   }
	 
	 public parameterTest(Integer inputNumber, Boolean expectedResult) {
	      this.inputNumber = inputNumber;
	      this.expectedResult = expectedResult;
	   }

	@Test
	public void testPrime(){
		//assertEquals(false,calc.isPrimeNo(10));
		//assertEquals(true,calc.isPrimeNo(11));
		assertEquals(expectedResult,c.isPrimeNo(inputNumber));
	}
	
	 @Parameterized.Parameters
	   public static Collection primeNumbers() {
	      return Arrays.asList(new Object[][] {
	         { 2, true },
	         { 6, false },
	         { 19, true },
	         { 22, false },
	         { 23, true },
	         { 24, false },
	         { 37, true },
	      });
	   }
}
