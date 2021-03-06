package com.wll.test.luaandredis;

public class Lua {

	public final static String INCR=""
			+" local money_temp = redis.call('hget',KEYS[1],KEYS[2]) "
			+" local argv,money = tonumber(ARGV[1]),tonumber(money_temp)"
			+" if money then "
			+"     local x = string.format(\"%0.2f\",argv+money)"
			+"     redis.call('hset',KEYS[1],KEYS[2],x) "
			+"     return  1"
			+" end ";
	
	public final static String DECR=""
			+" local money_temp = redis.call('hget',KEYS[1],KEYS[2]) "
			+" local argv,money = tonumber(ARGV[1]),tonumber(money_temp) "
			+" if money then "
			+"     if money >= argv then"
			+"        local x = string.format(\"%0.2f\",money-argv)"
			+"        redis.call('hset',KEYS[1],KEYS[2],x) "
			+"        return 1"
			+"     else "
			+"        return -1"
			+"     end "
			+" end ";
	
	public final static String INCR_FREEZE=""
			+" local balance = redis.call('hget',KEYS[1],KEYS[2]) "
			+" local freeze_balance = redis.call('hget',KEYS[1],KEYS[3])"
			+" local argv,money,freeze_money = tonumber(ARGV[1]),tonumber(balance),tonumber(freeze_balance)"
			+" if money and freeze_money then "
			+" 	if money >= argv then "
			+"    	local m = string.format(\"%0.2f\",money - argv)"
			+"		local fm = string.format(\"%0.2f\",freeze_money + argv)"
			+"     	redis.call('hset',KEYS[1],KEYS[2],m) "
			+"     	redis.call('hset',KEYS[1],KEYS[3],fm) "
			+"     	return  1"
			+"	else"
			+ "		return -1"
			+ "	end"
			+" end ";
	
	public final static String DECR_FREEZE=""
			+" local balance = redis.call('hget',KEYS[1],KEYS[2]) "
			+" local freeze_balance = redis.call('hget',KEYS[1],KEYS[3])"
			+" local argv,money,freeze_money = tonumber(ARGV[1]),tonumber(balance),tonumber(freeze_balance)"
			+" if freeze_money and money then "
			+" 	if freeze_money >= argv then "
			+"    	local fm = string.format(\"%0.2f\",freeze_money - argv) "
			+"		local m = string.format(\"%0.2f\",money + argv)"
			+"     	redis.call('hset',KEYS[1],KEYS[2],m) "
			+"     	redis.call('hset',KEYS[1],KEYS[3],fm) "
			+"     	return  1"
			+"	else"
			+ "		return -1"
			+ "	end"
			+" end ";
	
	/**
	 * 初始化支付中心三个账户
	 * KEYS,ARGV
	 */
	public final static String INIT_ACCOUNT=""
			+"for n=1,3,1 do"
			+" local key = KEYS[n]"
			+" redis.call('hmset',key,ARGV[1],ARGV[2],"
			+" ARGV[3],ARGV[4],ARGV[5],ARGV[6],ARGV[7],ARGV[8],ARGV[9],ARGV[10]"
			+" ,ARGV[11],ARGV[12],ARGV[13],ARGV[14])"
			+" end ";
	
	/* 用户刷礼物 
	 * 返回值说明：
	 * 0 : 用户不存在
	 * 1 : 消费成功
	 * -1 : 余额不足
	 */
	public final static String DECR_BASJOO =""
			+" local consumer_leaf = redis.call('hget',KEYS[1],KEYS[2]) "
			+" local reciver_coin = redis.call('hget',KEYS[3],KEYS[4]) "
			+" local argv = tonumber(ARGV[1]) "
			+" local consume_money = tonumber(consumer_leaf) "
			+" local recive_money = tonumber(reciver_coin) "
			+" if argv == nil or consume_money == nil or recive_money == nil then "
			+"     return 0"
			+" end "
			+" if consume_money and recive_money then "
			+"     if consume_money >= argv then"
			+"        local x = consume_money - argv"
			+"        local y = recive_money + argv "
			+"        redis.call('hset',KEYS[1],KEYS[2],x) "
			+"        redis.call('hset',KEYS[3],KEYS[4],y) "
			+"        return 1"
			+"     else "
			+"        return -1"
			+"     end "
			+" end ";

	public final static String GET = ""+
			"return redis.call('get','bb')";
}
