package com.wll.test.javabase.Class;

public class TestClient {

	public static void main(String[] args) {
		Object object = getObject();
		System.out.println(object.getClass().getName());
	}
	
	public static Object getObject(){
		Student stu = new Student();
		return stu;
	}
}
