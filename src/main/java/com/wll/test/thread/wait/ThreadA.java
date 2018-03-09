package com.wll.test.thread.wait;

public class ThreadA extends Thread{

	public ThreadA(String name){
		super(name);
	}
	
	@Override
	public void run() {
		synchronized (this) {
			try {
				for(int i=0;i<10;i++){
					System.out.println(i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"当前线程执行notify()");
			/* 唤醒当前执行的线程 */
			//this.notify();
		}
	}
}
