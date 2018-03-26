package com.zy.jd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.zy.sort.easySelectSort;
//统计文件中出现次数最多的单词，输出该单词和个数
public class countWordsNum {

	public static void main(String[] args) throws FileNotFoundException {
		
		BufferedReader bfd = new BufferedReader(new FileReader(new File("/Users/allzhou/Desktop/test.txt")));
		//String str = "Look to the skies above London and you'll see the usual suspects rainclouds, plane and pigeons. But by the end of the year, you might just see something else.";
		String str = null;
		StringBuilder stb = new StringBuilder();
		String[] strs = {};
		try {
			String lineStr = null;
			while((lineStr = bfd.readLine()) != null){
				lineStr = lineStr.replace("\'", " ");
				lineStr = lineStr.replace(",", " ");
				lineStr = lineStr.replace(".", " ");
				stb.append(lineStr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		str = stb.toString();
		strs = str.split("\\s+");// “\\s+”代表一个或多个空格，是正则表达式
		//Use map to store word and its numbers.
		Map<String, Integer> map = new HashMap<String,Integer>();
		//List<String> list = new ArrayList<String>();
		for(String s : strs){
			if(map.containsKey(s)){
				map.put(s, map.get(s) + 1);
			}else{
				map.put(s, 1);
				//list.add(s);
			}
		}
		int maxCount = 0;
		String maxNumWord = null;
//		for(String s : list){
//			if(map.get(s) > maxCount){
//				maxCount = map.get(s);
//				maxNumWord = s;
//			}
//		}
		List<Entry<String, Integer>> listMap = map.entrySet()
												 .stream().sorted(Map.Entry.<String,Integer> comparingByValue().reversed())
												 .collect(Collectors.toList());
		for(int i = 0; i < 3; i++){
			System.out.println("排序后: " + listMap.get(i).getKey() + "->" + listMap.get(i).getValue());
		}
		//System.out.println("出现次数最多的单词是: " + maxNumWord + ", 共出现了" + maxCount + "次");
	}
}
