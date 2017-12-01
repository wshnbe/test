package com.wll.test.test;

public class TestInteger {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Integer test = Integer.getInteger("test", 10);
		String name = System.getProperty("test");
		System.out.println(name);
	}
}
