package com.balu.learn;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runners.MethodSorters;

import com.balu.data.Calculator;
import com.balu.data.CalculatorService;

@RunWith(MockitoJUnitRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MockitoTest {
	
	@InjectMocks
		CalculatorService mockService1 = new CalculatorService();
	
	@Mock
		Calculator calc1 = new Calculator();	
	
	// mocking next level class which we dont want to test
	// mock using mock method
	CalculatorService mockService = Mockito.mock(CalculatorService.class);
	Calculator calc = new Calculator(mockService);
	//execute only once, in the starting 
	   @BeforeClass
	   public static void beforeClass() {
	      System.out.println("in before class");
	   }

	   //execute only once, in the end
	   @AfterClass
	   public static void  afterClass() {
	      System.out.println("in after class");
	   }

	   //execute for each test, before executing test
	   @Before
	   public void before() {
	      System.out.println("in before");
	   }
		
	   //execute for each test, after executing test
	   @After
	   public void after() {
	      System.out.println("in after");
	   }
	
//@Test
@Test(expected = RuntimeException.class)
public void testWithMockAdd() {
	System.out.println("Test1");
	 doThrow(new RuntimeException("Add operation not implemented"))
     .when(mockService).performMat(2,3);
	 //when(mockService.performMat(2, 3)).thenReturn(50);
	assertEquals(50,calc.add(2, 3));
	//verify(mockService, times(2)).performMat(2, 3);
    //verify(mockService, atLeast(2)).performMat(2,3);
    //verify(mockService, atLeastOnce()).performMat(2,3);
	//verify(mockService, atMost(2)).performMat(2,3);

	 
	//verify(mockService).performMat(2, 3);
}
@Test
public void testWithMockSum() {
	System.out.println("Test2");
	when(mockService.performMat(5, 6)).thenReturn(110);
	assertEquals(110,calc.add(5, 6));
	
}

@Test
public void testWithRange() {
	ArrayList<Integer> listInt = new  ArrayList<>(Arrays.asList(1,2,3,4,5,6));
	
	System.out.println("Test3");
	when(mockService.getNumbers(6)).thenReturn(listInt);
	assertEquals(21,calc.sumRange(6));

}

}
