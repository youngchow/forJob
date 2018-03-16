package com.zy.sort;

/**
 * 二分插入排序
 * @author zy
 *
 */
public class BinaryInsertSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
		System.out.println("排序前: ");
		print(a);
		sort(a);
		System.out.println("排序后: ");
		print(a);
	}

	private static void sort(int[] a) {
		for(int i = 1; i < a.length; i++){
			if(a[i] < a[i-1]){
				// 缓存i处的元素值
				int temp = a[i];
				int low = 0;
				int high = i - 1;
				while(low <= high){
					int mid = (low + high) / 2;
					if(temp < a[mid]){
						high = mid - 1;
					}else {
						low = mid + 1;
					}
				}
				//将low~i处数据整体向后移动1位
				for(int j = i; j > low; j--){
					a[j] = a[j-1];
				}
				if(low != i){
					a[low] = temp;
				}
			}
		}
		
	}
	private static void print(int[] data){
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
