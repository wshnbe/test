package com.wll.test.redis;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import redis.clients.jedis.Jedis;

public class RedisClient {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("localhost",6379);
		String script = getScript();
		if(script != null){
			String sha = jedis.scriptLoad(script);
			System.out.println("sha是:"+sha);
		}else{
			System.out.println("null");
		}
	}
	
	
	@SuppressWarnings("resource")
	public static String getScript(){
		StringBuffer sb = new StringBuffer();
		
		File file = new File("/Users/wulinli/insert_zset.lua");
		BufferedReader reader = null;
		try {
			String temp = null;
			reader = new BufferedReader(new FileReader(file));
			while((temp = reader.readLine()) != null){
				sb.append(temp+"\r");
			}
			String result = sb.toString();
			System.out.println("结果是:"+result);
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
