package com.wll.test.javabase.single;

import java.util.Random;

public class ThreadTest extends Thread{
	
	@Override
	public void run() {
		SingleOne one  = SingleOne.getSingleOne();
		Random rand = new Random();
		int a = rand.nextInt();
		try {
			one.setValue(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
