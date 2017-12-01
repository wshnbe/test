package com.wll.test.thread;

public class client {
	
	public static void main(String args[]){
		System.out.println(TriggerStatic.TEST);
		System.out.println(TriggerStatic.TESTONE);
		System.out.println("--------------------------分界线-----------------------------");
		Thread thread = new Thread(new TriggerThread());
		thread.start();
	}
}
