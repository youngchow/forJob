package com.zy.sort;
/**
 * 简单选择排序(不稳定)
 * 1、基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 * @author zy
 *
 */
public class easySelectSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
		System.out.println("排序前: ");
		print(a);
		sort(a);
		System.out.println("排序后: ");
		print(a);
	}

	private static void sort(int[] data) {
		for(int i = 0; i < data.length; i++){
			int min = data[i];
			int n = i;//最小数的索引
			for(int j = i+1; j < data.length; j++){
				if(data[j] < min){//找出最小的数
					min = data[j];
					n = j;
				}
			}
			data[n] = data[i];
			data[i] = min;
		}
		
	}

	private static void print(int[] data) {
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
