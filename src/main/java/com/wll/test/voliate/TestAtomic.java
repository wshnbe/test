package com.wll.test.voliate;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TestAtomic {

	public static void main(String[] args) {
		AtomicInteger count = new AtomicInteger(0);
		AtomicReference<Thread> owner = new AtomicReference<Thread>();
	}
}
