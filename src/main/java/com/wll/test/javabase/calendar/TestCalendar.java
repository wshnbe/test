package com.wll.test.javabase.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {

	private static final Integer DATE_DAY = 1;
	private static final Integer DATE_HOUR = 2;
	private static final Integer DATE_MINUE = 3;
	
	/**
	 * 计算当前时间差
	 * type：1:按天计算 2：按小时计算
	 * @param type
	 * @param timeValue
	 * @return
	 */
	public static Date getQueryTime(Integer type,Integer timeValue){
		if(type != null && timeValue != null){
			Calendar calendar = Calendar.getInstance();
			/* 按天天计算 */
			if(type.equals(DATE_DAY)){
				calendar.add(Calendar.DAY_OF_MONTH, timeValue);
			}
			/* 按小时计算 */
			else if(type.equals(DATE_HOUR)){
				calendar.add(Calendar.HOUR_OF_DAY, timeValue);
			}
			/* 按分钟计算 */
			else if(type.equals(DATE_MINUE)){
				calendar.add(Calendar.MINUTE, timeValue);
			}
			return calendar.getTime();
		}
		return new Date();
	}
	
	public static void main(String[] args) {
		Date date = TestCalendar.getQueryTime(3, 10);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
	}
}
