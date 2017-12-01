package com.wll.test.thread.threadlocal;

public class TestBean {

	private static ThreadLocal<Integer> num = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 2;
		}
	};
	
	public int getValue(){
		num.set(num.get() + 1);
		return num.get() ;
	}
}
