package com.zy.jd;

public class getIndex {

	public static void main(String[] args) {
		int[] nums = {1,2,4,6,-6,3,4,6};
		int index = getNumIndex(nums);
		if(index == -1){
			System.out.println("该数组中没有符合要求的元素");
		}else{
			System.out.println("该元素在数组中的索引位置为： " + index + ", 其值为：" + nums[index]);
		}
	}

	private static int getNumIndex(int[] nums) {
		int sumLeft = 0;
		int sumRight = 0;
		int index = -1;
		for(int i = 0, j = nums.length - 1; i <= j;){
			sumLeft += nums[i];
			sumRight += nums[j];
			while(i < j){
				if(sumLeft < sumRight){
					i++;
					sumLeft += nums[i];
				}else if(sumLeft > sumRight){
					j--;
					sumRight += nums[j];
				}else{
					i++;
					j--;
				}
			}
			if(i == j && sumLeft == sumRight){
				index = i;
				i++;
			}
			if(i > j){
				break;
			}
		}
		return index;
	}
}
