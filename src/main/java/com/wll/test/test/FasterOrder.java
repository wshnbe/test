package com.wll.test.test;

/**
 * 快速排序
 * @author wulinli
 *
 */
public class FasterOrder {

	public static void main(String args[]) {
		int[] nums = new int[] { 2, 1, 4, 5, 8, 7, 6, 3, 9, 0 };
		/* 快速排序算法不能随便设置 左边值 和 右边值 ,只能是开始下标 和结束下标 */
		quick_sort(nums,0,nums.length-1);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}

	public static void quick_sort(int s[], int l, int r) {
		if (l < r) {
			int i = l, j = r, x = s[l];
			while (i < j) {
				while (i < j && s[j] >= x){
					j--;
				}
				if (i < j){
					s[i++] = s[j];
					System.out.println("中间数是:" +x);
				}
				while (i < j && s[i] < x){
					i++;
				}
				if (i < j){
					s[j--] = s[i];
				}
			}
			s[i] = x;
			quick_sort(s, l, i - 1); // 递归调用
			quick_sort(s, i + 1, r);
		}
	}
	
	public static void quicksort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }
 
   public  static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }
}
