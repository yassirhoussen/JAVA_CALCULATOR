package com.calculator.utils;

public class Executor {

	public static double add (double value1, double value2) {
		return value1 + value2;
	}

	public static double sub (double value1, double value2) {
		return value1 - value2;
	}
	
	public static double mult (double value1, double value2) {
		if (value1 == 0 ||value2 == 0)
			return 0.0;
		else {
			return value1 * value2;
		}
	}
	
	public static double div (double value1, double value2)  {
		if (value2 == 0)
			throw new IllegalArgumentException ("Unable to divide par zero!");
		else 
			return value1/value2;
	}
}
