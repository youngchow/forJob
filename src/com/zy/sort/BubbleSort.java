package com.zy.sort;

import javax.security.auth.kerberos.KerberosKey;

/**
 * 冒泡排序：稳定 若文件初状为正序，则一趟起泡就可完成排序，排序码的比较次数为n-1，且没有记录移动，时间复杂度是O(n)
 * 若文件初态为逆序，则需要n-1趟起泡，每趟进行n-i次排序码的比较，比较和移动次数均达到最大值∶O(n2)
 * 起泡排序平均时间复杂度为O(n2) 加入needNextPass改进冒泡排序
 * 
 * @author zy
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 176, 113, 127, 49, 78, 34, 12, 164, 11, 18, 1 , 99, 44, 100, 101, 55, 102, 23, 58, 69, 54, 12, 2, 6, 200, 201, 
				202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214};
		System.out.println("排序前: ");
		print(a);
		long startTime = System.nanoTime();
		//bubbleSort1(a);
		//bubbleSort2(a);
		bubbleSort3(a);
		long endTime = System.nanoTime();
		System.out.println("排序运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间
		System.out.println("排序后: ");
		print(a);
	}

	//原始思想
	public static void bubbleSort1(int[] data){
		int n = data.length;
		for(int i = 0; i < n; i++){
			for(int j = 1; j < n - i; j++){
				if(data[j - 1] > data[j]){
					int temp = data[j - 1];
					data[j - 1] = data[j];
					data[j] = temp;
				}
			}
		}
	}
	
	//第一次优化，加入flag标志
	private static void bubbleSort2(int[] data) {
		boolean needNextPass = true;
		int n = data.length;
		for (int i = 0; i < n && needNextPass; i++) {
			// Array may be sorted and next pass not needed.
			needNextPass = false;
			// 这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
			for (int j = 1; j < n - i; j++) {
				if (data[j - 1] > data[j]) {
					int temp = data[j];
					data[j] = data[j - 1];
					data[j - 1] = temp;
					needNextPass = true;
				}
			}
		}

	}

	//优化后的，对于后边已经排好序的，只需要进行一次比较
	 private static void bubbleSort3(int[] data){
		 int i, j;
		 int flag = data.length;//flag来记录最后交换的位置，也就是排序的尾边界
		 while(flag > 0){//排序未结束标志
			 j = flag;//j 来记录遍历的尾边界
			 flag = 0;
			 for(i = 1; i < j; i++){
				 if(data[i - 1] > data[i]){//前面的数字大于后面的数字就交换
					 int temp = data[i - 1];
					 data[i - 1] = data[i];
					 data[i] = temp;
					//表示交换过数据;
					 flag = i;//记录最新的尾边界.
				 }
			 }
		 }
	 }
	
	private static void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
