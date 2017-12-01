package com.wll.test.javabase.single;

public class SingleOne {

	private static SingleOne one = new SingleOne();
	private SingleOne(){}
	
	public static SingleOne getSingleOne(){
		return one;
	}
	
	public synchronized void setValue(int value) throws Exception{
		System.out.println("之前");
		System.out.println(value);
	}
}
