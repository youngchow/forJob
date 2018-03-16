package com.zy.sort;

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
		int[] a = { 49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };
		System.out.println("排序前: ");
		print(a);
		sort(a);
		System.out.println("排序后: ");
		print(a);
	}

	private static void sort(int[] data) {
		boolean needNextPass = true;
		for (int i = 1; i < data.length && needNextPass; i++) {
			// Array may be sorted and next pass not needed.
			needNextPass = false;
			// 这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
			for (int j = 0; j < data.length - i; j++) {
				if (data[j] > data[j + 1]) {
					int temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
					needNextPass = true;
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
