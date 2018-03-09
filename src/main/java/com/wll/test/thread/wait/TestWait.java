package com.wll.test.thread.wait;

public class TestWait {

	public static void main(String[] args) {
		ThreadA ta = new ThreadA("ta");
		synchronized (ta) {
			try {
				System.out.println(Thread.currentThread().getName()+" ta线程启动");
				ta.start();
				System.out.println(Thread.currentThread().getName()+" ta线程执行wait()方法");
				//此方法 会使 当前主线程等待
				ta.wait();
				System.out.println(Thread.currentThread().getName()+" continue");  
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
