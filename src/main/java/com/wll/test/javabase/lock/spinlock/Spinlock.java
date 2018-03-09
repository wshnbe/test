package com.wll.test.javabase.lock.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 当多线程出现低程度的竞争时，可以使用自旋锁 替代阻塞
 * 
 * 可重入锁
 * @author wulinli
 *
 */
public class Spinlock {

	private int count;
	private AtomicReference<Thread> cThread = new AtomicReference<Thread>();
	
	public void lock(){
		/* current thread */
		Thread thread = Thread.currentThread();
		/* reentrant */
		if (thread == cThread.get()){
			count++;
			System.out.println("count:"+count);
			return ;
		}
		while(!cThread.compareAndSet(null,thread)){
			
		}
		count++;
		System.out.println("count:"+count);
	}
	
	public void unlock(){
		Thread thread = Thread.currentThread();
		if(thread == cThread.get()){
			if(count > 0){
				count--;
				System.out.println("count:"+count);
				if(count == 0){
					cThread.compareAndSet(thread, null);
				}
			}
		}
	}
}
