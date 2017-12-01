package com.wll.suanfa.efcz;

import java.util.ArrayList;
import java.util.List;

public class ErFenChaZhao {

	/* 用来缓存用户数据经验 */
	private static List<Integer> cacheLevel = new ArrayList<Integer>();
	
	static{
		cacheLevel.add(0);
		cacheLevel.add(10);
		cacheLevel.add(20);
		cacheLevel.add(30);
		cacheLevel.add(40);
		cacheLevel.add(50);
		cacheLevel.add(60);
		cacheLevel.add(70);
		cacheLevel.add(80);
		cacheLevel.add(90);
		cacheLevel.add(100);
		cacheLevel.add(110);
		cacheLevel.add(120);
		cacheLevel.add(130);
		cacheLevel.add(140);
		cacheLevel.add(150);
		cacheLevel.add(160);
		cacheLevel.add(170);
		cacheLevel.add(180);
		cacheLevel.add(190);
		cacheLevel.add(200);
	}
	
	private static int searchlevel(int start,int end,int exper){
		int index = (start + end) / 2;
		Integer stanExper = cacheLevel.get(index);
		if(exper > stanExper){
			start = index;
			if(index+1 == end){
				return stanExper;
			}else{
				return searchlevel(start,end,exper);
			}
		}else if(exper < stanExper){
			end = index;
			if(index-1 == start){
				return cacheLevel.get(start);
			}else{
				return searchlevel(start,end,exper);
			}
		}else if(exper == stanExper){
			return stanExper;
		}
		return 0 ;
	}
	
	public static void main(String[] args) {
		int exper = 8;
		int result = searchlevel(0,20,exper);
		System.err.println("Result："+result);
	}
}
