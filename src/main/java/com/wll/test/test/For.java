package com.wll.test.test;

public class For {
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			for(int y=0;y<10;y++){
				if(i==2){
					break;
				}
				System.out.println(i);
			}
			System.out.println("bb"+i);
		}
	}
}
