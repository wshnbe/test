package com.wll.test.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		String str = list.toString();
		str = str.substring(1, str.length()-1) ;
		System.out.println(str);
		
		Set<String> sets = new HashSet<String>();
		sets.add("a");
		sets.add("b");
		list.addAll(sets);
		System.out.println(list);
	}
}
