package com.wll.sjjg.stack;

import java.util.Stack;

public class StackNode {

	public static int getSize(){
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		return s.peek();
	}
	
	public static void main(String[] args) {
		System.out.println(getSize());
	}
}
