package com.balu.data;

import java.util.List;

public class Calculator {
   
	CalculatorService c = null;
	   
	public Calculator(CalculatorService c){
		this.c = c;
	}
   	
    public Calculator() {
	}

    public int add(int a, int b) {
    	   
	   if(c == null) {
		   System.out.println("service is Null");
		   c = new CalculatorService();
	   }
	try {
		c.performMat(a, b);   
	} catch(RuntimeException e) {
		System.out.println("Exception,,,,,,,,,,,,"+e.getMessage());
		throw e;
	}
	return c.performMat(a, b);
   }
    
   public int sumRange(int x) {
	  // c = new CalculatorService();

	   List<Integer> list = c.getNumbers(x);
	   int sum = list.stream().mapToInt(i->i.intValue()).sum();
	   //int sum = list.stream().mapToInt(Integer::intValue).sum();
	   
	    System.out.println("SumRange Sum ="+ sum);
	    return sum;
   }
   
   public Boolean isPrimeNo(final Integer primeNumber) {
	      for (int i = 2; i < (primeNumber / 2); i++) {
	         if (primeNumber % i == 0) {
	            return false;
	         }
	      }
	      return true;
	   }
}
