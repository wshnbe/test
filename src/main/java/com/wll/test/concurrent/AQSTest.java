package com.wll.test.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {
	
	private ReentrantLock lock = new ReentrantLock();
	private CyclicBarrier cb = new CyclicBarrier(10);
	private CountDownLatch cdl = new CountDownLatch(10);
	
	public static void main(String args[]){
		String a = new String("a");
	}
	
	public void testAQS(){
		
	}
}
