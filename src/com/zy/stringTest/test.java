package com.zy.stringTest;

public class test {

	public static void main(String[] args) {
		String testStr = "hello world";
//		String[] strs = testStr.split(" ");
//		StringBuilder sBuilder = new StringBuilder();
//		for(int i = 0; i < strs.length / 2; i++){
//			String temp = strs[i];
//			strs[i] = strs[strs.length - i - 1];
//			strs[strs.length - i - 1] = temp;
//		}
//		for(int i = 0; i < strs.length; i++){
//			sBuilder.append(strs[i] + " ");
//		}
		String reverse = " ";
		char[] chars = testStr.toCharArray();
		for(int i = chars.length - 1; i >= 0; i--){
			reverse += chars[i];
		}
		System.out.println(reverse.toString());
	}
}
