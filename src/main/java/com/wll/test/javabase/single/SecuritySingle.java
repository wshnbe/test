package com.wll.test.javabase.single;

public class SecuritySingle {

	private SecuritySingle(){}
	
	private static  class SingleContainer{
		private static SecuritySingle single = new SecuritySingle();
	}
	
	public static SecuritySingle getInstance(){
		return SingleContainer.single;
	}
}
