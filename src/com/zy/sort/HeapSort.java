package com.zy.sort;

/**
 * 堆排序：不稳定
 * 堆排序优于简单选择排序的原因：
　　直接选择排序中，为了从R[1..n]中选出关键字最小的记录，必须进行n-1次比较，然后在R[2..n]中选出关键字最小的记录，
        又需要做n-2次比较。事实上，后面的n-2次比较中，有许多比较可能在前面的n-1次比较中已经做过，但由于前一趟排序时未保
        留这些比较结果，所以后一趟排序时又重复执行了这些比较操作。
        堆排序可通过树形结构保存部分比较结果，可减少比较次数。
　　堆排序的最坏时间复杂度为O(nlogn)。堆序的平均性能较接近于最坏性能。由于建初始堆所需的比较次数较多，
        所以堆排序不适宜于记录数较少的文件。
 * @author zy
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
		System.out.println("排序前: ");
		print(a);
		//循环建堆
		for(int i = 0; i < a.length - 1; i++){
			//建堆
			buildMaxHeap(a,a.length - 1 - i);
			//交换堆顶和最后一个元素  
			swap(a,0,a.length - 1 - i);
		}
		System.out.println("排序后: ");
		print(a);
	}
	//对data数组从0到lastIndex建大顶堆
	private static void buildMaxHeap(int[] data, int lastIndex) {
		//从lastIndex处节点（最后一个节点）的父节点开始
		for(int i = (lastIndex - 1) / 2; i >= 0; i--){
			//k保存正在判断的节点 
			int k = i;
			//如果当前k节点的子节点存在
			while(k * 2 + 1 <= lastIndex){
				//k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				//如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if(biggerIndex < lastIndex){
					//若果右子节点的值较大
					if(data[biggerIndex] < data[biggerIndex+1]){
						//biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				//如果k节点的值小于其较大的子节点的值
				if(data[k] < data[biggerIndex]){
					//交换他们
					swap(data,k,biggerIndex);
					//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k = biggerIndex;
				}else {
					break;
				}
			}
		}
		
	}
	//交换
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	private static void print(int[] data) {
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
