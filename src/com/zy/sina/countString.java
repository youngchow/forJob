package com.zy.sina;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 统计文本中某个字符串出现的次数
 * @author yang5.zhou
 *
 */
public class countString {

	public static int count(String file, String target){
		int count = 0;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(new File(file));
			br = new BufferedReader(fr);
			String lineStr = null;
			while((lineStr = br.readLine()) != null){
				int index = -1;
				while(lineStr.length() > target.length() && (index = lineStr.indexOf(target)) >= 0){
					count++;
					lineStr = lineStr.substring(index + target.length());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {  
            try {  
                fr.close();  
                br.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }
		return count;
	}
	
	public static void main(String[] args) {
		String file = "C:\\Users\\yang5.zhou\\Desktop\\test.txt";
		String target = "abcd";
		System.out.println(count(file, target));
	}
}