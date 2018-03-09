package com.wll.test.javabase.base.staticfinal;

public class TestStaticFinal {

	static{
		System.out.println("Super init");
		T = 10;
		S = 10;
	}
	public static final int T ;
	public static int S ;
}

class SubClass extends TestStaticFinal{

	static{
		System.out.println("Sub init");
	}
}