package com.zy.sort;
/**希尔排序的原理:
 * 1、基本思想：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中。
 * 先在各组内进行直接插入排序；然后，取第二个增量d2<d1重复上述的分组和排序，
 * 直至所取的增量dt=1(dt<dt-l<…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
 * 该方法实质上是一种分组插入方法。
 * -------------------------------------------------------------------
 * 根据需求，如果你想要结果从大到小排列，它会首先将数组进行分组，然后将较大值移到前面，较小值 
 * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，可以说希尔排序是加强 
 * 版的插入排序 .拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列 
 * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较 
 * 此例子是按照从大到小排列，所以大的会排在前面，第一次排序后数组为9, 2, 8, 5, 1, 3，4 
 * 第一次后increment的值变为3/2=1,此时对数组进行插入排序， 
 */  
//不稳定
public class ShellSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
		System.out.println("排序前: ");
		print(a);
		sort(a);
		System.out.println("排序后: ");
		print(a);
	}
	private static void sort(int[] data) {
		/*int j = 0;
		int temp = 0;
		for(int increment = data.length / 2; increment > 0; increment /= 2){
			for(int i = increment; i < data.length; i++){
				temp = data[i];
				for(j = i; j > increment; j -= increment){
					if(temp > data[j-increment]){
						data[j] = data[j-increment];
					}else {
						break;
					}
				}
				data[j] = temp;
			}
		}*///有重复元素不适用
		int d = data.length;
		while(true){
			d = d / 2;
			for(int x = 0; x < d; x++){
				for(int i = x + d; i < data.length; i = i + d){
					int temp = data[i];
					int j;
					for(j = i - d; j >= 0 && data[j] > temp; j = j - d){
						data[j+d] = data[j];
					}
					data[j+d] = temp;
	             }
	           }
            if(d == 1){
               break;
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
