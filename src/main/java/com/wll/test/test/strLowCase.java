package com.wll.test.test;

import java.util.Date;

public class strLowCase {

	public static void main(String[] args) {
		String str = "BcAB";
		byte[] items = str.getBytes(); 
		items[0] = (byte)((char)items[0]-'A'+'a');
		System.out.println(new String(items));
		
		long times = new Date().getTime();
		System.out.println(times);
	}
}
