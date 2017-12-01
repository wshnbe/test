package com.wll.sjjg.ecs;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinTreeOther {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeT root = new NodeT();
		root.data = 9;

		NodeT temp01 = new NodeT();
		temp01.data = 1;
		root.left = temp01;

		NodeT temp02 = new NodeT();
		temp02.data = 3;
		root.right = temp02;

		NodeT temp03 = new NodeT();
		temp03.data = 2;
		root.left.left = temp03;

		NodeT temp04 = new NodeT();
		temp04.data = 4;
		root.left.right = temp04;

		NodeT temp05 = new NodeT();
		temp05.data = 8;
		root.right.left = temp05;

		NodeT temp06 = new NodeT();
		temp06.data = 6;
		root.left.left.left = temp06;

		NodeT temp07 = new NodeT();
		temp07.data = 7;
		root.left.left.right = temp07;

		System.out.println("--------先序遍历----------");
		SelectTree1(root);
		System.out.println();
		System.out.println("---------中序遍历---------");
		SelectTree(root);
		System.out.println();
		System.out.println("---------后序遍历---------");
		SelectTree2(root);
		System.out.println();
		System.out.println("----------叶节点个数-----------");
		int i = leafNum(root);
		System.out.println(i);
		System.out.println("----------层次遍历二叉树-----------------");
		levelOrder(root);

		System.out.println();
		int j = deep(root);
		System.out.println("---------高度---------");
		System.out.println(j);

	}

	// 中序遍历
	public static void SelectTree(NodeT root) {
		if (root == null)
			return;
		SelectTree(root.left);
		System.out.print(root.data + " ");
		SelectTree(root.right);
	}

	// 先序遍历
	public static void SelectTree1(NodeT root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		SelectTree1(root.left);
		SelectTree1(root.right);
	}

	// 后序遍历
	public static void SelectTree2(NodeT root) {
		if (root == null)
			return;
		SelectTree2(root.left);
		SelectTree2(root.right);
		System.out.print(root.data + " ");

	}

	// 叶子数
	public static int leafNum(NodeT NodeT) {
		if (NodeT != null) {
			if (NodeT.left == null && NodeT.right == null) {
				return 1;
			}
			return leafNum(NodeT.left) + leafNum(NodeT.right);
		}
		return 0;
	}

	// 求二叉树的深度
	public static int deep(NodeT NodeT) {
		int h1, h2;
		if (NodeT == null) {
			return 0;
		} else {
			h1 = deep(NodeT.left);
			h2 = deep(NodeT.right);
			return (h1 < h2) ? h2 + 1 : h1 + 1;
		}

	}

	// 层次遍历
	public static void levelOrder(NodeT NodeT) {
		if (NodeT == null)
			return;
		Queue<NodeT> queue = new ArrayDeque<NodeT>();
		queue.add(NodeT);
		while (!queue.isEmpty()) {
			NodeT temp = queue.poll();
			System.out.print(temp.data);
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}
}

class NodeT {
	boolean visited = false;
	int data = 0;
	NodeT left = null;
	NodeT right = null;
}
