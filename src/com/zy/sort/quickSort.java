package com.zy.sort;
/**
 * 1、基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
 * 一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地
 * 排序划分的两部分。
 * 快速排序是不稳定的排序。
　　快速排序的时间复杂度为O(nlogn)。
　　当n较大时使用快排比较好，当序列基本有序时用快排反而不好。
 * @author zy
 *
 */
public class quickSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
		System.out.println("排序前: ");
		print(a);
		sort(a,0,a.length-1);
		System.out.println("排序后: ");
		print(a);
	}
	
	private static void sort(int[] data, int low, int high) {
		if(low < high){//如果不加这个判断递归会无法退出导致堆栈溢出异常
			int middle = getMiddle(data,low,high);
			sort(data, 0, middle - 1);
			sort(data, middle + 1, high);
		}
	}

	private static int getMiddle(int[] data, int low, int high) {
		int temp = data[low];//基准元素
		while(low < high){
			//找到比基准元素小的元素位置
			while(low < high && data[high] >= temp){
				high--;
			}
			data[low] = data[high];
			while(low < high && data[low] <= temp){
				low++;
			}
			data[high] = data[low];
		}
		data[low] = temp;
		return low;
	}

	private static void print(int[] data) {
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
