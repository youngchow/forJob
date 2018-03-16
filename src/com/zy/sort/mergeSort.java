package com.zy.sort;
/**
 * 1、基本思想:归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * 归并排序是稳定的排序方法。
　　归并排序的时间复杂度为O(nlogn)。推导过程递归调用
　　速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列。
 * @author zy
 *
 */
public class mergeSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
		System.out.println("排序前: ");
		print(a);
		//sort(a,0,a.length-1);
		mergeSortAl(a);
		System.out.println("排序后: ");
		print(a);
	}

	/*private static void sort(int[] data, int left, int right) {
		if(left < right){
			int middle = (left + right) / 2;
			//对左边进行递归
			sort(data, left, middle);
			//对右边进行递归
			sort(data, middle + 1, right);
			//合并
			merge(data,left,middle,right);
		}
	}

	private static void merge(int[] data, int left, int middle, int right) {
		int[] tempArr = new int[data.length];
		int mid = middle + 1;//右边的起始位置
		int temp = left;
		int third = left;
		while(left <= middle && mid <= right){
			//从两个数组中选取较小的数放入中间数组
			if(data[left] <= data[mid]){
				tempArr[third++] = data[left++];
			}else {
				tempArr[third++] = data[mid++];
			}
		}
		//将剩余的部分放入中间数组
		while(left <= middle){
			tempArr[third++] = data[left++];
		}
		while(mid <= right){
			tempArr[third++] = data[mid++];
		}
		//将中间数组复制回原数组
		while(temp <= right){
			data[temp] = tempArr[temp++];
		}
	}*/
	
	

	private static void mergeSortAl(int[] list) {
		if(list.length > 1){
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSortAl(firstHalf);
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSortAl(secondHalf);
			int[] temp = merge(firstHalf,secondHalf);
			System.arraycopy(temp, 0, list, 0, temp.length);
		}
		
	}

	private static int[] merge(int[] list1, int[] list2) {
		int[] temp = new int[list1.length + list2.length];
		int current1 = 0; //current index in list1
		int current2 = 0; //current index in list2
		int current3 = 0; //current index in temp
		while(current1 < list1.length && current2 < list2.length){
			if(list1[current1] < list2[current2]){
				temp[current3++] = list1[current1++];
			}else{
				temp[current3++] = list2[current2++];
			}
		}
		while(current1 < list1.length){
			temp[current3++] = list1[current1++];
		}
		while(current2 < list2.length){
			temp[current3++] = list2[current2++];
		}
		return temp;
	}

	private static void print(int[] data) {
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
