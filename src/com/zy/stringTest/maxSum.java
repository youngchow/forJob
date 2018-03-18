package com.zy.stringTest;

import java.util.Arrays;

public class maxSum {

	public static void main(String[] args) {
        int[] num = {-1,2,7,-9,3,6,8,2,-10};
        int maxSum = 0;
        int[] re = max(num);
        for(int i = 0; i < re.length; i++) {
        	System.out.print(re[i] + " ");
        	maxSum += re[i];
        }
        System.out.println("最大和是： " + maxSum);
    }
 
    public static int[] max(int[] num){
        return max(num,num.length-1);
    }
 
    public static int[] max(int[] num,int length){
        int[] re = Arrays.copyOfRange(num,0,length);
        for(int i=1;i<=num.length-length;i++){
            if(sum(re) < sum(Arrays.copyOfRange(num,i,i+length) ) ){
                re = Arrays.copyOfRange(num,i,i+length);
            }
        }
        if( length>2 && sum(max(num,length-1))>sum(re)  ){
            re = max(num,length-1);
        }
        return re;
    }
 
    public static long sum(int[] num){
        long re = 0;
        for(int n:num)  re += n;
        return re;
    }
}
