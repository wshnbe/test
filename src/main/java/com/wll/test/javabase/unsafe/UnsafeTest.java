package com.wll.test.javabase.unsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class UnsafeTest {

	private volatile int count;
	
	public static void main(String[] args) {
		AtomicReference<Thread> cur = new AtomicReference<Thread>();
		AtomicInteger i = new AtomicInteger(0);
		
	}
}
