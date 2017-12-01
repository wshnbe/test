package com.wll.suanfa.sort.swapsort;

/**
 * Bubble sort
 * 
 * @author wulinli
 */
public class BubblingSort {

	public static void bubbleSort(int a[]) {
		if (a == null || a.length == 0)
			return;
		for (int i = 0; i < a.length-1; i++) {
			for(int j=i+1;j<a.length;j++){
				if(a[i] > a[j]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int a[] = { 3, 1, 5, 7, 2, 4, 9, 6, 10, 8 };
		System.out.println("初始值：");
		BubblingSort.print(a);
		System.out.println();
		System.out.println("排序后的值是：");
		BubblingSort.bubbleSort(a);
		BubblingSort.print(a);
		
	}
	
	public static void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
