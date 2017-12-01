package com.wll.suanfa.erchashu;

import java.util.LinkedList;
import java.util.List;

public class MyBinTree {

	private static int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	private static List<Node> nodeList = null;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int newData) {
			left = null;
			right = null;
			this.data = newData;
		}
	}

	public static void createTree() {
		nodeList = new LinkedList<Node>();
		// 将一个数组的值依次转换为Node节点
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new Node(array[nodeIndex]));
		}
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// 左孩子
			nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
			// 右孩子
			nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
		}
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
		int lastParentIndex = array.length / 2 - 1;
		// 左孩子
		nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子
		if (array.length % 2 == 1) {
			nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
		}
	}

	/**
	 * 前序遍历
	 */
	public static void preOrderTraverse(Node node) {
		if (node == null)
			return;
		System.out.print(node.data+" ");
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}

	/**
	 * 中序遍历
	 */
	public static void inOrderTraverse(Node node) {
		if (node == null)
			return;
		inOrderTraverse(node.left);
		System.out.print(node.data+" ");
		inOrderTraverse(node.right);
	}

	/**
	 * 后序遍历
	 */
	public static void postOrderTraverse(Node node) {
		if (node == null)
			return;
		postOrderTraverse(node.left);
		postOrderTraverse(node.right);
		System.out.print(node.data+" ");
	}
	
	public static void main(String[] args) {
		MyBinTree.createTree();
		Node node = MyBinTree.nodeList.get(0);
		System.out.println("前序遍历：");
		MyBinTree.preOrderTraverse(node);
		System.out.println();
		System.out.println("中序遍历：");
		MyBinTree.inOrderTraverse(node);
		System.out.println();
		System.out.println("后序遍历：");
		MyBinTree.postOrderTraverse(node);
	}
}
