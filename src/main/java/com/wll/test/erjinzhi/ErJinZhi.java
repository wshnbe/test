package com.wll.test.erjinzhi;

public class ErJinZhi {

	public static void main(String[] args) {
		String txt = "11111111111111111111111111111";
		int tmp = txt.length();
		int sum = 0;
		for(int i=tmp-1;i>=0;i--){
			int num = Integer.parseInt(txt.substring(i,i+1));
			int tmpSum = 1;
			for(int y=0;y<=tmp-2-i;y++){
				tmpSum *=2;
			}
			sum += num*tmpSum;
		}
		System.out.println(sum);
	}
}
