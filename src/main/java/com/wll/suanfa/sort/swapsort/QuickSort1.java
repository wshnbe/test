package com.wll.suanfa.sort.swapsort;

/**
 * QuckSort by Myself
 * 
 * @author wulinli
 *
 */
public class QuickSort1 {

	public static void main(String[] args) {
		int a[] = { 3, 1, 5, 7, 2, 4, 9, 6, 10, 8 };
		System.out.println("初始值：");
		QuickSort1.print(a);
		int h = a.length - 1;
		System.out.println("\n排序后：");
		QuickSort1.quickSort(a, 0, h);
		QuickSort1.print(a);
	}

	public static void quickSort(int a[], int low, int high) {
		if (low < high) {
			int middle = traverse(a, low, high);
			quickSort(a, 0, middle);
			quickSort(a, middle+1, high);
		}
	}

	private static int traverse(int a[], int low, int high) {
		int key = a[low];
		while (low < high) {
			// 先比较位置比较大的一边
			for (; low < high && a[high] >= key;)
				high--;
			a[low] = a[high];
			// 在比较小的一边
			for (; low < high && a[low] < key;)
				low++;
			a[high] = a[low];
		}
		a[high] = key;
		return high;
	}

	public static void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
