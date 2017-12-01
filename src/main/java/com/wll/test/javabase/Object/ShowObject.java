package com.wll.test.javabase.Object;

public class ShowObject {

	public static void main(String[] args) {
		Book book  = new programmerBook();
		book.showName();
	}
}

class Book{
	
	public void showName(){
		System.out.println("这是父类书名");
		showAuthorName();
	}
	
	public void showAuthorName(){
		System.out.println("这是父类作者名");
	}
}

class programmerBook extends Book{
	
	public void showName(String name){
		System.out.println("这是子类"+name);
	}
	
	public void showAuthorName(){
		System.out.println("这是子类作者名");
	}
}