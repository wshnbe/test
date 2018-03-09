package com.wll;

import java.util.Hashtable;

public class TEST {

	public static void main(String[] args) {
		/* 添加一行测试内容 */
		Hashtable<String, String> hs = new Hashtable<String, String>();
		System.out.println(hs);
		String test = hs.get("test");
		System.out.println(test);
		String version = "1.1.1".replace(".", "");
		int v = Integer.parseInt(version);
		System.out.println(v);
		
	}
}
