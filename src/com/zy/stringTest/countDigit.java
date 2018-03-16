package com.zy.stringTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 写段代码，定义一个字符串常量，字符串中只有大小写字母和整数，输出字符串中的出现最多的数字的和？例如 ” 9fil3dj11P0jAsf11j ” 中出现最多的是11两次，输出22.
 * @author yang5.zhou
 *
 */
public class countDigit {

	public static int countNumbers(String source){
		int number = 0;
		int value = 0;
		String[] strs = source.split("[^0-9]");
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < strs.length; i++){
			//System.out.print(strs[i] + " ");
			if(!"".equals(strs[i])){
				int key = Integer.valueOf(strs[i]);
				if(map.containsKey(key)){
					map.put(key, map.get(key) + 1);
				}else {
					map.put(key, 1);
				}
				if(number < map.get(key)){
					number = map.get(key);
					value = key;
				}
			}
		}
		return number * value;
	}
	
	public static void main(String[] args) {
		String source = "9fil3dj11P0jAsf111j11a111cc11";
		int total = countNumbers(source);
		System.out.println(total);
	}
}
