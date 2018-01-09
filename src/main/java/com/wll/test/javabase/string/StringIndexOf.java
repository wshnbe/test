package com.wll.test.javabase.string;

public class StringIndexOf {

	public static void main(String[] args) {
		String path = "com/test/aa/cron";
		String switchPath = path.replace("cron", "switch");
		System.out.println(switchPath);
		System.out.println(path.substring(0,path.lastIndexOf("/")+1));
	}
}
