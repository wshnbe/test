package com.wll.test.test;

public class NewFastOrder20160202 {

	public static void main(String[] args) {
		
	}
	
	/**
	 * 排序主体
	 * @param s
	 * @param l
	 * @param r
	 */
	public void sort(int s[],int l,int r){
		int left = l;
		int right = r;
		int temp = s[left];
		while(left < right){
			while(left < right && s[right] >= temp){
				right--;
			}
			if(left < right){
				s[left++] = s[right];
			}
			while(left < right && s[left] < temp){
				left++;
			}
			if(left < right){
				
			}
		}
	}
}
