package com.wll.test.test;

import java.util.Date;

public class TestTime {

	public static void main(String[] args) {
		System.out.println("这是毫秒数的时间：" + System.currentTimeMillis()/1000);
		System.out.println("这是unix时间戳:" + new Date().getTime());
	}
}
