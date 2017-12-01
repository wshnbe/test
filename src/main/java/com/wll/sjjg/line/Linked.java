package com.wll.sjjg.line;

import java.util.Stack;

public class Linked {
	
	Node first = new Node(0);
	Node tail = first;
	
	public static void main(String[] args) {
		Linked link = new Linked();
		link.addLast(1);
		link.addLast(2);
		link.addLast(3);
		link.addLast(4);
		link.addLast(5);
		link.addLast(6);
		link.addLast(7);
		link.addLast(8);
		link.addLast(9);
		link.linkTraverse();
		System.out.println("reversal：");
//		link.linkRevesal();
		link.linkTraverse();
	}
	
	/**
	 * add element first
	 * @param data
	 */
	public Node addFirst(int data){
		Node node = new Node(data);
		node.next = first;
		first = node;
		return tail;
	}
	
	/**
	 * add element tail
	 * @param data
	 */
	public Node addLast(int data){
		Node node = new Node(data);
		tail.next = node;
		tail = node;
		return first;
	}
	
	/**
	 * find element 
	 * @param data
	 */
	public Node find(int data){
		Node n = first;
		while(n != null){
			if(n.data == data)
				return n;
			n = n.next;
		}
		return null;
	}
	
	/**
	 * traverse 
	 */
	public void linkTraverse(){
		if(first != null){
			Node n = first;
			while(n != null){
				System.out.print(n.data+" ");
				n = n.next;
			}
		}
	}
	
	/**
	 * revesal
	 */
	public void linkRevesal(){
		if(first != null){
			Stack<Node> stack = new Stack<Node>();
			Node n = first;
			while(n != null){
				stack.push(n);
				n = n.next;
			}
			if(!stack.isEmpty()){
				first = stack.pop();
				Node p = first;
				Node c = null;
				while(!stack.isEmpty()){
					c = stack.pop();
					p.next = c;
					p = c;
				}
				p.next = null;
				tail = p;
			}
		}
	}
}

class Node{
	int data;
	Node next;
	Node(int d){
		this.data = d;
		next = null;
	}
}