package com.wll.test.javabase.base;

import java.math.BigInteger;

import org.junit.Test;

public class TestBase {

	@Test
	public void testBigInteger() {
		BigInteger num = new BigInteger("");
		System.out.println(num);
	}

	@Test
	public void showNum() {
		for (int i = 0; i < 200; i++) {
			long time = System.currentTimeMillis();
			long s = time % 2;
			if (s == 0) {
				System.out.println(0);
			} else if (s == 1) {
				System.out.println(1);
			}
		}
	}
}
