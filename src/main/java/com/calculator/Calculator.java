package com.calculator;

public class Calculator {

	public static void main(String[] args){
		System.out.println("6 + 3 = " + add(6, 3));
		System.out.println("6 - 3 = " + subtract(6,3));
		System.out.println("6 * 3 = " + multiply(6,3));
		System.out.println("6 / 3 = " + divide(6,3));
	}
//  I'm writing this comment here and i will push it to github repository. Jenkins should automatically trigger the build when it sees any changes in the github repository.
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int subtract(int a, int b) {
		return a - b;
	}

	public static long multiply(int a, int b) {
		return a * b;
	}

	public static double divide(int a, int b) {
		double result;
		if (b == 0) {
			throw new IllegalArgumentException("Divisor cannot divide by zero");
		} else {
			result = Double.valueOf(a)/Double.valueOf(b);
		}
		return result;
	}
}
