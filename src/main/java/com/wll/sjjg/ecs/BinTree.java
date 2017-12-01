package com.wll.sjjg.ecs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BinTree {

	static BinTree tree = new BinTree();
	Node root = null;
    int size = 0;
	
	BinTree(){
		root = new Node(0);
		size += 1;
	}
	
	/**
	 * get first child node 
	 */
	public Node getFirstChild(Node node){
		return node == null ? null : node.left;
	}
	
	/**
	 * get parent
	 * @param node
	 */
	public Node getParent(Node node){
		if(root == null)
			return null;
		if(node == null)
			return null;
		if(root == node)
			return null;
		return getTraverseParentNode(root,node);
	}
	
	/**
	 * 遍历二叉树全部的节点，找到和目标节点相同的节点，然后获取到它的父节点。
	 * @param source
	 * @param node
	 * @return
	 */
	public static Node getTraverseParentNode(Node source,Node node){
		if(source == node)
			return source;
		if(source.left != null && source.left == node){
			return source;
		}
		if(source.right != null && source.right == node){
			return source;
		}
		if(source.left == null)
			return null;
		if(source.right == null)
			return null;
		Node resultL = getTraverseParentNode(source.left,node);
		Node resultR = getTraverseParentNode(source.right,node);
		if(resultL != null )
			return resultL;
		if(resultR != null)
			return resultR;
		return null;
	}
	
	/**
	 * get next brother node,if null return null
	 * @param node
	 */
	public Node getNextSibling(Node node){
		if(node == null)
			return null;
		Node parentNode = getParent(node);
		if(parentNode == null)
			return null;
		if(parentNode.left == node)
			return parentNode.right;
		if(parentNode.right == node)
			return parentNode.left;
		return null;
	}
	
	/**
	 * previous Order
	 * DLR
	 * @param node
	 */
	public static void preOrder(Node node){
		if(node == null)
			return ;
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 *  while circle traverse
	 *  DLR previous order
	 * @param node
	 */
	public static void preOrderLoop(Node node){
		if(node == null)
			return; 
		Stack<Node> stack = new Stack<Node>();
		Node n = node;
		while(n != null || !stack.isEmpty()){
			while(n != null){
				System.out.print(n.data+" ");
				stack.push(n);
				n = n.left;
			}
			if(!stack.isEmpty()){
				n = stack.pop();
				n = n.right;
			}
		}
	}
	
	/**
	 * middle order 
	 * LDR
	 * @param node
	 */
	public static void midOrder(Node node){
		if(node == null)
			return ;
		midOrder(node.left);
		System.out.print(node.data+" ");
		midOrder(node.right);
	}
	
	/**
	 *  while circle traverse
	 *  LDR middle order
	 * @param node
	 */
	public static void midOrderLoop(Node node){
		if(node == null) 
			return ;
		Stack<Node> stack = new Stack<Node>();
		Node n = node;
		while(n != null || !stack.isEmpty()){
			while(n != null){
				stack.push(n);
				n = n.left;
			}
			if(!stack.isEmpty()){
				n = stack.pop();
				System.out.print(n.data+" ");
				n = n.right;
			}
		}
	}
	
	/**
	 * post order 
	 * LRD
	 */
	public static void postOrder(Node node){
		if(node == null)
			return ;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
	
	/**
	 *  while circle traverse
	 *  LRD post order
	 * @param node
	 */
	public static void postOrderLoop(Node node){
		if(node == null) 
			return ;
		Node n = node;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Integer> s2 = new Stack<Integer>();
		while(n != null || !s1.isEmpty()){
			while(n != null){
				s1.push(n);
				s2.push(new Integer(0));
				n = n.left;
			}
			while(!s1.isEmpty() && s2.peek().equals(1)){
				s2.pop();
				System.out.print(s1.pop().data+" ");
			}
			if(!s1.isEmpty()){
				s2.pop();
				s2.push(new Integer(1));
				n = s1.peek();
				n = n.right;
			}
		}
	}
	
	/**
	 * level order
	 *  LinkedList 
	 */
	public static void levelOrder(Node node){
		if(node == null)
			return ;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(node);
		Node current = null;
		while(!queue.isEmpty()){
			current = queue.poll();
			System.out.print(current.data+" ");
			if(current.left != null)
				queue.offer(current.left);
			if(current.right != null)
				queue.offer(current.right);
		}
	}
	
	/**
	 * level order
	 * 
	 * deque
	 * @param node
	 */
	public static void levelOrderDeque(Node node){
		if(node == null)
			return ;
		Deque<Node> deque = new ArrayDeque<Node>();
		deque.addFirst(node);
		Node current = null;
		while(!deque.isEmpty()){
			current = deque.poll();
			System.out.print(current.data+" ");
			if(current.left != null)
				deque.addLast(current.left);
			if(current.right != null)
				deque.addLast(current.right);
		}
	}
	
	/**
	 * get root node 
	 */
	public Node getRoot(){
		return root;
	}
	
	/**
	 * get size
	 */
	public int getSize(Node node){
		if(node == null)
			return 0;
		return 1+getSize(node.left)+getSize(node.right);
	}
	
	/**
	 * 获取二叉树的高度
	 * @return
	 */
	public static int getHeight(Node node){
		if(node == null)
			return 0;
		int i = getHeight(node.left);
		int j = getHeight(node.right);
		return (i>j)?i+1:j+1;
	}
	
	/**
	 * 创建二叉树
	 *   		  0
	 *   	1			      2
	 *   3	   4	      5	        6
	 * 7   8     9     10   11   12
	 * 								13
 	 */
	public static void createTree(){
		//第1层
		Node node1_1 = new Node(1);
		Node node1_2 = new Node(2);
		
		//第2层
		Node node2_1 = new Node(3);
		Node node2_2 = new Node(4);
		
		Node node2_3 = new Node(5);
		Node node2_4 = new Node(6);
		
		//第3层
		Node node3_1 = new Node(7);
		Node node3_2 = new Node(8);
		
		Node node3_3 = new Node(9);
		Node node3_4 = new Node(10);
		
		Node node3_5 = new Node(11);
		Node node3_6 = new Node(12);
		
		Node node4_1 = new Node(13);
		
		node2_1.left = node3_1;
		node2_1.right = node3_2;
		node2_2.right = node3_3;
		node2_3.left = node3_4;
		node2_3.right = node3_5;
		node2_4.left = node3_6;
		
		node3_6.right = node4_1;
		
		node1_1.left = node2_1;
		node1_1.right = node2_2;
		
		node1_2.left = node2_3;
		node1_2.right = node2_4;
		
		tree.root.left = node1_1;
		tree.root.right = node1_2;
//		Node result = getTraverseParentNode(tree.root,tree.root);
//		System.out.println(result.data);
		
	}
	
	public static void main(String[] args) {
		createTree();
//		System.out.println("先序遍历,递归：");
//		preOrder(tree.root);
//		System.out.println();
//		System.out.println("先序遍历,非递归：");
//		preOrderLoop(tree.root);
		
//		System.out.println("中序遍历,递归：");
//		midOrder(tree.root);
//		System.out.println();
//		System.out.println("中序遍历,非递归：");
//		midOrderLoop(tree.root);
		
		System.out.println("后序遍历,递归：");
		postOrder(tree.root);
		System.out.println();
		System.out.println("后序遍历,非递归：");
		postOrderLoop(tree.root);
		
//		int height = getHeight(tree.root);
//		System.out.println("二叉树高度是："+height);
//		System.out.println("中序遍历：");
//		midOrder(tree.root);
//		System.out.println();
//		System.out.println("后序遍历：");
//		postOrder(tree.root);
//		System.out.println();
//		System.out.println("层级遍历：");
//		levelOrderDeque(tree.root);
		
	}
}

class Node {
	
	//节点数据
	int data;
	//左节点
	Node left;
	//右节点
	Node right;
	
	Node(int d){
		this.left = null;
		this.right = null;
		this.data = d;
	}
}