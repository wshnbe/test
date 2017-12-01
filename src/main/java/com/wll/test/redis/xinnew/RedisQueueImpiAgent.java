package com.wll.test.redis.xinnew;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

import com.ttmv.datacenter.agent.redis.RedisPoolConfig;
import com.ttmv.datacenter.agent.redis.queue.RedisQueueImpi;

public class RedisQueueImpiAgent {

	@Test
	public void TestAddData() throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("localhost", 6379, config, 30000);
		String json = "{\"stars\":[{\"userID\":56,\"ranking\":1,\"activityID\":22,\"score\":8000,\"levelName\":\"第一关\",\"Gifts\":[{\"productID\":1,\"sum\":98,\"limitSum\":100},{\"productID\":2,\"sum\":80,\"limitSum\":100}]},{\"userID\":57,\"ranking\":2,\"activityID\":22,\"score\":7000,\"levelName\":\"第一关\",\"Gifts\": [{\"productID\":1,\"sum\":98,\"limitSum\":100},{\"productID\":2,\"sum\":50,\"limitSum\":100}]}]}";
		jedis.setValue("dams_swingtag_que", json);
	}
	
	/**
	 * 模拟明星排行榜数据
	 * @throws Exception
	 */
	@Test
	public void addStarRankData()throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.157", 51313, config, 30000);
		for(int i=0;i<1000;i++){			
			String json = "[{\"userID\": 1,\"activityID\": \"2222\",\"score\": 98000,\"time\": 1452567208},{\"userID\": 2,\"activityID\": \"2222\",\"score\": 92000,\"time\": 1452567208}]";
			jedis.setValue("dams_star_rankactivity_que", json);
		}
	}
	
	/**
	 * 模拟用户排行榜数据
	 * @throws Exception
	 */
	@Test
	public void addUserRankData()throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.153", 50042, config, 30000);
		for(int i=0;i<1000;i++){			
			String json = "[{\"userID\": 1,\"activityID\": \"2222\",\"score\": 98000,\"time\": 1452567208},{\"userID\": 2,\"activityID\": \"2222\",\"score\": 92000,\"time\": 1452567208}]";
			jedis.setValue("dams_swingtag_que", json);
		}
	}
	
	/**
	 * 模拟吊牌活动数据
	 * @throws Exception
	 */
	@Test
	public void addSwingTagRankData()throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("127.0.0.1", 6379, config, 30000);
		for(int i=0;i<1;i++){			
			String json ="{\"userID\": 100,\"ranking\": 1,\"activityID\": 22,\"levelLogoPC\":\"a.jpg\",\"levelLogoMC\":\"b.jpg\",\"score\": "+(i*100)+",\"levelName\":\"第一关\",\"Gifts\":"+
								"[{\"productID\": 1,\"sum\": 98,\"limitSum\": 100},{\"productID\": 2,\"sum\": 80,\"limitSum\": 100}]}";
			jedis.setValue("dams_swingtag_que", json);
		}
	}
	
	@Test
	public void TestUpLevel()throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.153", 50041, config, 30000);
		String user = "{\"userID\":100,\"levelType\":\"user\",\"level\":100,\"exp\":10000}";
		String star = "{\"userID\":101,\"levelType\":\"star\",\"level\":100,\"exp\":10000}";
		jedis.setValue("PS_upLevel_Queue", user);
		jedis.setValue("PS_upLevel_Queue", star);
	}
	
	@Test
	public void addFlower()throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.181", 50043, config, 30000);
		//String user = "{\"userID\":100,\"levelType\":\"user\",\"level\":100,\"exp\":10000}";
		//String star = "{\"userID\":101,\"levelType\":\"star\",\"level\":100,\"exp\":10000}";
		for(int i=0;i<1;i++){
			String flower = "{\"userID\":4,\"destinationUserID\":2155,\"clientType\":\"1\",\"type\":\"flower\",\"count\":1,\"roomID\":\"100\",\"time\":\"1234567890\"}";
			jedis.setValue("SDCS_flower_Queue", flower);
			//jedis.setValue("SDCS_heart_Queue", heart);
		}
	}
	
	@Test
	public void addOnline()throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.181", 50043, config, 30000);
		//"SDCS_starOnline_Queue";
		//"SDCS_userOnline_Queue";
		for(int i=0;i<1;i++){
			String start = "{\"userID\":2155,\"type\":\"up\",\"time\":\"1234567890\"}";

			//jedis.setValue("SDCS_userOnline_Queue",user);
			jedis.setValue("SDCS_starOnline_Queue",start);
		}
		
	}
	
	@Test
	public void addUserExp()throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.153", 51313, config, 30000);
		for(int i=0;i<100;i++){
			String message = "{\"userID\":2000,\"exp\":null,\"announcerExp\":220000,\"userLevel\":null,\"announcerLevel\":3}";
			jedis.setValue("dams_exp_que",message);
		}
	}

	@Test
	public void addUser()throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.153", 51313, config, 30000);
		for(int i=0;i<100;i++){
			String message = "{\"userID\":2000,\"exp\":null,\"announcerExp\":220000,\"userLevel\":null,\"announcerLevel\":3}";
			jedis.setValue("SDCS_starOnline_Queue",message);
			jedis.setValue("SDCS_userOnline_Queue",message);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void addSetData()throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.153", 51313, config, 30000);
		for(int i=0;i<100;i++){
			System.out.println(jedis.getSetValues("test"));
		}
	}
	
	@Test
	public void showSetData()throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.153", 51313, config, 30000);
		List<String> listStrings = new ArrayList<String>();
		Set<String> sets = jedis.getSetValues("test");
		listStrings.addAll(sets);
		System.out.println(listStrings);
	}
	
	@Test
	@SuppressWarnings("unused")
	public void getRedis()throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.153", 50042, config, 30000);
		long start = System.	currentTimeMillis();
		for(int i=0;i<100;i++){
			String data = jedis.getValue("dams_swingtag_que1");
			System.out.println(data);
		}
		System.out.println("结束的数据是:" + (System.currentTimeMillis() - start));
		long temp = System.	currentTimeMillis();
		List<String> lists = jedis.getValueBatch("dams_swingtag_que", 100);
		System.out.println("批量取数据是:" + (System.currentTimeMillis() - temp));
	}

	@Test
	@SuppressWarnings("resource")
	public void getKeys(){
		Jedis jedis = new Jedis("localhost", 6379);
		List<Long> lists = new ArrayList<Long>();
		Set<String> sets = jedis.keys("20160131*");
		for(String str:sets){
			lists.add(new Long(str));
		}
		Object obj[] = lists.toArray();
		sort(obj);
		for(int i=0;i<obj.length;i++){
			System.out.println(obj[i].toString());
		}
	}
	
	@Test
	public void testDeleteValueByList(){
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.153", 51313, config, 30000);
		try {
			jedis.setValue("test", "test");
			jedis.delValue("test", "test");
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void TestAddActivity() throws Exception{
		RedisPoolConfig config = new RedisPoolConfig(108,20,60000);
		RedisQueueImpi jedis = new RedisQueueImpi("192.168.13.181", 51313, config, 30000);
		String json = "{\"spendId\":\"126243\",\"spendToId\":\"134966\",\"presentId\":\"14\",\"presentNum\":\"188\",\"tb\":null,\"tq\":18800.0,\"time\":1466661251}";
		jedis.setValue("da_activity_qu", json);
	}
	
	/**
	 * 快速排序法
	 * @param s
	 * @param l
	 * @param r
	 */
	@SuppressWarnings("unused")
	private  void quick_sort(Object[] s, int l, int r) {
		if (l < r) {
			// Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
			int i = l, j = r;
			long x = new Long(s[l].toString());
			while (i < j) {
				while (i < j && getObjectToLong(s[j]) >= x)
					// 从右向左找第一个小于x的数
					j--;
				if (i < j)
					s[i++] = s[j];
				while (i < j && getObjectToLong(s[i]) < x)
					// 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quick_sort(s, l, i - 1); // 递归调用
			quick_sort(s, i + 1, r);
		}
	}
	
	public long getObjectToLong(Object num){
		Long newValue = new Long(num.toString());
		return newValue;
	}
	
	public void sort(Object[] args) {
		for (int i = 0; i < args.length - 1; i++) {
			for (int j = i + 1; j < args.length; j++) {
				long temp;
				if (getObjectToLong(args[i]) < getObjectToLong(args[j])) {
					temp = getObjectToLong(args[j]);
					args[j] = getObjectToLong(args[i]);
					args[i] = temp;
				}
			}
		}
	}
}
