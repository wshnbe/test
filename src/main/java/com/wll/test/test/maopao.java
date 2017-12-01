package com.wll.test.test;

public class maopao {

	public static void main(String[] args) {
		int[] arg = new int[] { 2, 1, 4, 5, 8, 7, 6, 3, 9, 0 ,3,4,5,6,7,45,72,68,80,90};		
		new maopao().sort(arg);
		
		for(int i=0;i<arg.length;i++){
			System.out.println(arg[i]);
		}
	}

	public void sort(int[] args) {
		for (int i = 0; i < args.length - 1; i++) {
			for (int j = i + 1; j < args.length; j++) {
				int temp;
				if (args[i] > args[j]) {
					temp = args[j];
					args[j] = args[i];
					args[i] = temp;
				}
			}
		}
	}

}
