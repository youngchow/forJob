package com.zy.alibaba;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定一个query和一个text，均由小写字母组成。要求在text中找出以同样的顺序连续出现在query中的最长连续字母序列的长度。例如，
 * query为“acbac”，text为“acaccbabb”，那么text中的“cba”为最长的连续出现在query中的字母序列，因此，
 * 返回结果应该为其长度3。请注意程序效率。
 * 
 * @author yang5.zhou
 *
 */
public class getMaxLength {

	public static void main(String[] args) {
		myGetLong("acbadc","acaccbadbb");
	}

	private static void myGetLong(String query, String text) {
		
		int num = 0;
		int m = 0;
		int qlen = query.length();
		List<String> list = new ArrayList<String>();
		//TreeSet集合是用来对象元素进行排序的,同样他也可以保证元素的唯一
		Set<String> set = new TreeSet<String>();
		for(int i = 0; i < qlen; i++){
			for(int j = 1; j <= qlen; j++){
				if(j <= i){
					j = i + 1;
				}
				set.add(query.substring(i, j));
			}
		}
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			list.add(iterator.next());
		}
		
		for(int k = 0; k < list.size(); k++){
			if(text.contains(list.get(k)) && list.get(k).length() > num){
				num = list.get(k).length();
				m = k;
			}
		}
		System.out.println(text + "中的" + list.get(m) + "为最长的连续出现在" + query+ "中的字母序列");
		System.out.println("其长度为" + num);
	}
	
}