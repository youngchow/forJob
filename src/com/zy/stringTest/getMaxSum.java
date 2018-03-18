package com.zy.stringTest;

import java.util.ArrayList;
import java.util.List;

public class getMaxSum {

	public static void main(String[] args) {
		int[] num = { -1, 2, 7, -9, 3, 6, 8, 2, -10 };
		int[] newNum = getMaxArr(num);
		int sumMax = 0;
		System.out.print("新数组是{");
		for(int i = 0; i < newNum.length; i++) {
			System.out.print(newNum[i] + " ");
			sumMax += newNum[i];
		}
		System.out.println("}");
		System.out.println("最大和是： " + sumMax);
	}

	private static int[] getMaxArr(int[] num) {

		int maxSum = 0;
		int tempSum = 0;
		List<Integer> list = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		for(int i = 0; i < num.length; i++) {
			if(num[i] >= 0) {
				tempSum += num[i];
				tempList.add(num[i]);
			}else {
				if(tempSum > maxSum) {
					maxSum = tempSum;
					list = tempList;
				}
				tempSum = 0;
				tempList = new ArrayList<>();
			}
		}
		int newNum[] = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			newNum[i] = list.get(i);
		}
		return newNum;
	}
}
