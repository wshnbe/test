package com.wll.test.luaandredis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.ttmv.datacenter.agent.redis.RedisAgent;
import com.ttmv.datacenter.agent.redis.RedisPoolConfig;
import com.ttmv.datacenter.agent.redis.jedis.impl.JedisPoolAgent;

public class redisAgent {

	private RedisPoolConfig config = new RedisPoolConfig(20, 300, 6000);
	private RedisAgent redis = new JedisPoolAgent("192.168.15.23", 50031, config, 60000);
	private final String TCOIN = "TCOIN_";
	private final String TQUAN = "TQUAN_";
	private final String BROKERAGE = "BROKERAGE_";
	
	@Test
	public void testLua(){
		/* 设置Lua调用redis的key */
		List<String> keys = new ArrayList<String>();
		keys.add("12");
		keys.add("balance");
		keys.add("freezeBalance");
		/* 设置调用Lua脚本调用的值 */
		List<String> argvs = new ArrayList<String>();
		argvs.add("30");
		try {
			System.out.println(redis.evalLua(Lua.DECR_FREEZE, keys, argvs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始化账户
	 */
	@Test
	public void initAccount(){
		for(int i=0;i<3;i++){
			Map<String,String> maps = new HashMap<String,String>();
			maps.put("id", "14");
			maps.put("userId",i+"");
			maps.put("balance","0.0");
			maps.put("freezeBalance","0.0");
			maps.put("accountStatus","1");
			maps.put("created","20160510");
			maps.put("updated","20160510");
			List<String> keys = this.getKeys("101");
			List<String> values = this.getMuliFields(maps);
			try {
				redis.evalLua(Lua.INIT_ACCOUNT, keys,values);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 将map数据类型转换成指定的List数据结构类型
	 * @param map
	 * @return
	 */
	private List<String> getMuliFields(Map<String,String> map){
		List<String> list = new ArrayList<String>();
		Set<String> sets = map.keySet();
		for(String key :sets){
			String value = map.get(key).toString();
			list.add(key);
			list.add(value);
		}
		return list;
	}
	
	/**
	 * 组装keys
	 * @param userid
	 * @return
	 */
	private List<String> getKeys(String userid){
		List<String> keys = new ArrayList<String>();
		keys.add(TCOIN+userid);
		keys.add(TQUAN+userid);
		keys.add(BROKERAGE+userid);
		return keys ;
	}
}
