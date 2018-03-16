package com.zy.stringTest;
//使用两种方法把这个字符串中的单词首字母转为大写：String str = “hello java and android!”；
public class StringUpperCase {

	public static void main(String[] args) {
		String str = "hello java and android!";
		System.out.println(UpperFirstString(str));
	}
	
	public static String UpperFirstString(String str){
		StringBuilder sBuilder = new StringBuilder();
		String[] strings = str.split(" ");
		for(int i = 0; i < strings.length; i++){
			String string = strings[i].substring(0, 1).toUpperCase() + strings[i].substring(1);
			sBuilder.append(string + " ");
		}
		return sBuilder.toString();
	}
}
