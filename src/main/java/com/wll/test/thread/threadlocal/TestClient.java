package com.wll.test.thread.threadlocal;

public class TestClient extends Thread{

	private TestBean bean = null;
	public TestClient(TestBean bean){
		this.bean = bean;
	}
		
	@Override
	public void run() {
		for(int i=0;i<3;i++){
			System.out.println("线程名称：" +Thread.currentThread().getName() + ",变量int的值是：" + bean.getValue());
		}
	}
	
	public static void main(String[] args) {		
		TestBean bean = new TestBean();
		
		TestClient client1 = new TestClient(bean);
		TestClient client2 = new TestClient(bean);
		TestClient client3 = new TestClient(bean);
		client1.start();
		client2.start();
		client3.start();
	}
}
