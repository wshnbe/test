package com.wll.suanfa.sort.insertsort;

/**
 * shell sort 
 * reinforced insert sort //加强版的简单插入排序
 * @author wulinli
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int a[] = { 3, 1, 5, 7, 2, 4, 9, 6, 10, 8 };
		shellSort(a);
		print(a);
	}
	
	public static void shellSort(int a[]){
		if(a == null || a.length < 0)
			return ;
		int dk = a.length/2;
		while(dk >= 1){
			insertSort(a,dk);
			dk = dk/2;
		}
	}
	
	private static void insertSort(int a[],int dk){
		if(a == null || a.length < 0)
			return ;
		//进行直接排序
		for(int i=dk;i<a.length;i++){
			int cur = a[i];
			for(int j=i-dk;j>=0;j=j-dk){
				if(a[j]>cur){
					a[j+dk] = a[j];
					a[j] = cur;
				}
			}
		}
	}
	
	public static void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
