package com.wll.test.erjinzhi;

import org.junit.Test;

public class JavaBit {

	public static void main(String[] args) {
		short a = -1;
		System.out.println("相当于,1*2^2:"+(1 << 2));
		System.out.println("相当于,1*2^30:"+(1 << 30));
		System.out.println("相当于,4/2^1:"+(4 >> 1));
		System.out.println("相当于,15/2^2:"+(15 >> 2));
		System.out.println(a >>> 3);
		System.out.println("==============逻辑右移 >>> =============");  
        int m=-1;  
        System.out.println("移位前：m= "+m+" = "+Integer.toBinaryString(m)+"(B)");  
        m=m >>> 2;  
        System.out.println("移位后：m= "+m+" = "+Integer.toBinaryString(m)+"(B)");  
          
        System.out.println("---------------------------------");  
	}
	
	@Test
	public void showMessage(){
		int a = 1; // 00000000 00000000 00000000 00000001
		int b = -1; // -1的二进制是用-1的补码来表示
		//-1的原码：10000000 00000000 00000000 00000001
		//1 的反码：11111111 11111111 11111111 11111110 
		//补码 = 反码 + 1：11111111 11111111 11111111 11111111
		//移码符号位取反：01111111 11111111 11111111 11111111
		System.out.println("1 binary:"+Integer.toBinaryString(a));
		System.out.println("-1 binary:"+Integer.toBinaryString(b));
	}
	
}
