package com.wll.test.javabase.base;

public class TestString {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String a = "a";
		String b = "b";
		String c = "ab";//编译期能确定的值,都存放在constant pool中.
		String d = a + "b";
		String f = a + b;//运行时才能确定值的对象,都存放在heap堆中.
		String g = new String("a" + "b");
		System.out.println(g == f);
	}
	
	/**
	 * jdk1.8支持switch使用String类型的比较
	 */
//	public void showMessage(){
//		String a = "a";
//		switch (a) {
//		case "a":
//			
//			break;
//
//		default:
//			break;
//		}
//	}
}
