package com.wll.test.javabase.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/* 采用顺序存储结构 读取快,修改慢*/
		List<String> list = new ArrayList<String>();
		/* 采用单链存储结构 读取慢,修改快*/
		LinkedList<String> link = new LinkedList<String>();
	}
}
