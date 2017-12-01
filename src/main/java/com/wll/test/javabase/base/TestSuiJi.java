package com.wll.test.javabase.base;

import java.util.Random;

public class TestSuiJi {

	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			getRandomNumber();
		}
	}
	
	private static String getRandomNumber() {
		Random random = new Random();
		String numStr = String.valueOf((int)((1+random.nextDouble())*100000));
		return numStr.substring(numStr.length() - 5, numStr.length());
	}
}
