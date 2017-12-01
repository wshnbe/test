package com.wll.test.DataStruct;

/**
 * 二叉树逻辑结构和存储结构
 * @author wulinli
 *
 */
public class TreeNode {
	
	private int key = 0; //层序编码
	private String data = null; //节点数据
	private boolean isVisted = false; //
	private TreeNode leftNode = null;
	private TreeNode rightNode = null;
	
	public TreeNode(){}
	public  TreeNode(int key,String data){
		this.key = key;
		this.data = data;
		this.leftNode=null;  
        this.rightNode=null; 
	}

}
