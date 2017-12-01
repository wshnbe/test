package com.wll.test.javabase.longtime;

import java.util.Date;

/**
 * 显示long时间
 * @author wulinli
 */
public class ShowLongTime {

	public static void main(String args[]){
		System.out.println(System.currentTimeMillis());
		System.out.println(new Date().getTime());
		
		Date date = new Date(Long.parseLong("1458012934000"));
		System.out.println(date);
	}
}
