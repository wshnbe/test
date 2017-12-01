package com.wll.test.test;

public class MyselfFasterOrder {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 1, 4, 5, 8, 7, 6, 3, 9, 0 };
		sort(nums,0,nums.length -1);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}
	
	public static void sort(int s[],int start,int end){
		int i =start;
		int y = end;
		int temp = s[i];
		while( i < y ){
			while(i<y && s[y] >= temp){
				y--;
			}
			if(i<y){
				s[i++] = s[y];
			}
			while(i<y && s[i] < temp){
				i++;
			}
			if(i<y){
				s[y--] = s[i];
			}
		}
		s[i] = temp;
		sort(s,start,i-1);
		sort(s,i+1,end);
	}
}
