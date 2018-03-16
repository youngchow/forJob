package com.zy.sort;
/**
 * 直接插入排序
 * @author zy
 *
 */
public class directInsertSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,1};
		System.out.println("排序之前: ");
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		//直接插入排序:
		for(int i = 1; i < a.length; i++){
			//待插入元素
			int temp = a[i];
			int j;
			for(j = i - 1; j >= 0 && a[j] > temp; j--){
				a[j+1] = a[j];
			}
			a[j+1] = temp;
		}
		System.out.println();
		System.out.println("排序之后: ");
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
}
