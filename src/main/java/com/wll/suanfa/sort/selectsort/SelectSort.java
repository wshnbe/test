package com.wll.suanfa.sort.selectsort;

/**
 * simple select sort
 * @author wulinli
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		int a[] = { 3, 1, 5, 7, 2, 4, 9, 6, 10, 8 };
		selectSort(a);
		print(a);
	}
	
	public static void selectSort(int a[]){
		if(a == null || a.length < 0)
			return ;
		for(int i=0;i<a.length-1;i++){
			int min = i;
			for(int j=i+1;j<a.length;j++){
				if(a[min]>a[j])
					min = j;
			}
			if(min != i){
				int tmp = a[i];
				a[i] = a[min];
				a[min] = tmp;
			}
			
		}
	}
	
	public static void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
