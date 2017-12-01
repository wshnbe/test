package com.wll.test.test;

import org.junit.Test;

import com.google.common.base.Strings;

public class StringTest {

	@Test
	public void testString()throws Exception{
		String test = null ;
		System.out.println(Strings.isNullOrEmpty(test));
		String 咖啡 ="咖啡";
		System.out.println(咖啡);
	}
}
