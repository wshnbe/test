package com.wll.test.javabase.single;

public class TestClient {

	public static void main(String args[]){
		ThreadTest test1= new ThreadTest();
		ThreadTest test2= new ThreadTest();
		ThreadTest test3= new ThreadTest();
		ThreadTest test4= new ThreadTest();
		ThreadTest test5= new ThreadTest();
		ThreadTest test6= new ThreadTest();
		ThreadTest test7= new ThreadTest();
		ThreadTest test8= new ThreadTest();
		Thread t1 = new Thread(test1);
		Thread t2 = new Thread(test2);
		Thread t3 = new Thread(test3);
		Thread t4 = new Thread(test4);
		Thread t5 = new Thread(test5);
		Thread t6 = new Thread(test6);
		Thread t7 = new Thread(test7);
		Thread t8 = new Thread(test8);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
	}
}
