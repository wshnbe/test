package com.wll.test.redis.source;

public abstract class ListNode {
	//表头
	Node head;	
	//表尾
	Node tail;
	//表长度
	long len;
	//以下三个函数,实现多态链表
	abstract void dup(Object object);
	abstract void free(Object object);
	abstract void match(Object ptr,Object next);
}
