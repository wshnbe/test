package com.wll.test.thread;

public class TriggerThread implements Runnable{

	/**
	 * 线程执行体
	 */
	public void run() {
		for(int i = 0 ;i < 10 ;i ++){
			System.out.println("--------------i="+i+"----------------------");
			System.out.println("TriggerStatic.TEST ++ =" +TriggerStatic.TEST ++);
			System.out.println("TriggerStatic.TEST =" + TriggerStatic.TEST );
			System.out.println("++TriggerStatic.TESTONE = " +(++TriggerStatic.TESTONE));
			System.out.println("TriggerStatic.TESTONE = " + TriggerStatic.TESTONE);
		}
	}
}
