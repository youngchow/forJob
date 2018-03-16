package com.zy.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序：(分配式排序，桶子法)
 * 1、基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
 * 基数排序是稳定的排序算法。
　　基数排序的时间复杂度为O(d(n+r)),d为位数，r为基数。
 * @author zy
 *
 */
public class RadixSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
		System.out.println("排序前: ");
		print(a);
		sort(a);
		//sort(a,3);
		System.out.println("排序后: ");
		print(a);
	}
	
	private static void sort(int[] data) {
		//找到最大数，确定要排序几趟
		int max = 0;
		for(int i = 0; i < data.length; i++){
			if(max < data[i]){
				max = data[i];
			}
		}
		//判断位数
		int times = 0;
		while(max > 0){
			max = max / 10;
			times++;
		}
		//建立十个队列
		List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < 10; i++){
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}
		//进行times次分配和收集
		for(int i = 0; i < times; i++){
			//分配
			for(int j = 0; j < data.length; j++){
				//10的几次幂，可以获得每个元素的个位，十位，百位数字
				int x = (data[j] % (int)Math.pow(10, i+1)) / (int)Math.pow(10, i);
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(data[j]);
				queue.set(x, queue2);
			}
			//收集
			int count = 0;
			for(int j = 0; j < 10; j++){
				while(queue.get(j).size() > 0){
					ArrayList<Integer> queue3 = queue.get(j);
					data[count++] = queue3.get(0);
					queue3.remove(0);
				}
			}
		}
	}

	/*public static void sort(int[] number, int d) //d表示最大的数有多少位
    {
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][]temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[]order = new int[10]; //数组order[i]用来表示该位是i的数的个数
        while(m <= d)
        {
            for(int i = 0; i < number.length; i++)
            {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for(int i = 0; i < 10; i++)
            {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++)
                    {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }*/
	
	private static void print(int[] data){
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
