package com.wll.suanfa.sort.insertsort;

public class InsertSort {

	public static void main(String[] args) {
		int a[] = { 3, 1, 5, 7, 2, 4, 9, 6, 10, 8 };
		InsertSort obj = new InsertSort();
		System.out.println("初始值：");
		obj.print(a);
		obj.insertSort(a);
		System.out.println("\n排序后：");
		obj.print(a);

	}

	public void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {// 从头部第一个当做已经排好序的，把后面的一个一个的插到已经排好的列表中去。
			if (a[i] < a[i - 1]) {
				int j;
				int x = a[i];// x为待插入元素
				a[i] = a[i - 1];
				for (j = i - 1; j >= 0 && x < a[j]; j--) {// 通过循环，逐个后移一位找到要插入的位置。
					a[j + 1] = a[j];
				}
				a[j + 1] = x;// 插入
			}
		}
	}
}