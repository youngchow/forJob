package com.zy.stringTest;

//判断一个String是否是回文（顺读和倒读都一样的词）
public class isHuiWenShu {

	public static void main(String[] args) {
		String testStr1 = "abba";
		String testStr2 = "12345654321";
		String testStr3 = "helloworld";
		System.out.println(isPalindrome(testStr1) ? testStr1 + "是回文数" : testStr1 + "不是回文数");
		System.out.println(isPalindrome(testStr2) ? testStr2 + "是回文数" : testStr2 + "不是回文数");
		System.out.println(isPalindrome(testStr3) ? testStr3 + "是回文数" : testStr3 + "不是回文数");
		
		System.out.println(isPalindromeString(testStr1) ? testStr1 + "是回文数" : testStr1 + "不是回文数");
		System.out.println(isPalindromeString(testStr2) ? testStr2 + "是回文数" : testStr2 + "不是回文数");
		System.out.println(isPalindromeString(testStr3) ? testStr3 + "是回文数" : testStr3 + "不是回文数");
	}
	
	private static boolean isPalindrome(String str){
		if(str == null){
			return false;
		}
		StringBuilder stringBuilder = new StringBuilder(str);
		return stringBuilder.reverse().toString().equals(str);
	}
	
	private static boolean isPalindromeString(String str){
		if(str == null){
			return false;
		}
		int length = str.length();
		System.out.println(length / 2);
		for(int i = 0; i < length / 2; i++){
			if(str.charAt(i) != str.charAt(length - 1 - i)){
				return false;
			}
		}
		return true;
	}
}
