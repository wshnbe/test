package com.wll.suanfa.sort.insertsort;

public class InsertSortMy {

	public static void InserSort(int[] b) {
		if (b.length < 0)
			return;
		for (int i = 1; i < b.length; i++) {
			if (b[i] < b[i - 1]) {
				int j;
				int x = b[i];// 待插入的元素
				for (j = i - 1; j >= 0 && x < b[j]; j--) {
					b[j + 1] = b[j];
				}
				b[j + 1] = x;
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 3, 1, 5, 7, 2, 4, 9, 6, 10, 8 };
		System.out.println("初始值：");
		InsertSortMy.print(a);
		InsertSortMy.insertSort1(a);
		System.out.println("\n排序后：");
		InsertSortMy.print(a);

	}

	public static void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * 20170726 插入排序 复习
	 * 
	 * @param a
	 */
	public static void insertSort1(int a[]) {
		if (a == null || a.length <= 0)
			return;
		int len = a.length;
		for (int i = 1; i < len ; i++) {
			int cur = a[i];
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] > cur) {
					a[j+1]=a[j];
					a[j] = cur;
				}
			}
		}
	}
}
