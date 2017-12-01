package com.wll.test.voliate;

public class TestVolatile{

	private static  int index = 0;

	public static void inc(){
		
		TestVolatile.index++;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				public void run() {
					TestVolatile.inc();
				}
			}).start();
		}
		System.out.println(TestVolatile.index);
	}
}
