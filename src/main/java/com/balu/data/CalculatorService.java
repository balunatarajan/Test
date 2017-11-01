package com.balu.data;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
public int performMat(int i, int j) {
	System.out.println("Inside CalculatorService.performMat"+i+""+j);
	return (i+j) * 10;
}
public List<Integer> getNumbers(int a)
{
	System.out.println("Inside CalculatorService.getNumbers "+a);

	List<Integer> al = new ArrayList<>();
	for(int i = 1; i<= a; i++) {
		al.add(i);
	}
	
	return al;
}
}
