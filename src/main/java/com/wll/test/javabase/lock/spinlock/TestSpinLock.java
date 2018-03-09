package com.wll.test.javabase.lock.spinlock;

/**
 * 自旋锁测试 
 * @author wulinli
 *
 */
public class TestSpinLock {

	public static void main(String[] args) {
		Spinlock lock = new Spinlock();
		lock.lock();
		lock.lock();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		lock.unlock();
		lock.unlock();
	}
}

class Task extends Thread{

	public void run(){
		
	}
}

