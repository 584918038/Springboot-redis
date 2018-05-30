package redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.google.gson.Gson;
import com.xsh.springboot.entity.User;

import redis.clients.jedis.Jedis;

public class TestPersistence {
	/** Spring-data里面操作Redis的数据 */
	@Autowired
	private RedisTemplate redisTemplate;
	/** 写一个操作数据库的关系对象 */
	
	/**
	 * 將实体对象写入到Redis中
	 * 
	 */
	@Test
	public void test1() {
		User user = new User();
		user.setId(10);
		user.setName("scott");
		user.setPassword("123");
		// 写对象
		Jedis jedis = new Jedis("127.0.0.1");
		Gson gson = new Gson();
		String s = gson.toJson(user);
		jedis.set("user_"+user.getId(), s);
		jedis.close();
	}
	/**
	 * 将Redis里面的对象读取出来
	 */
	@Test
	public void test2() {
		int id = 10;
		
		Jedis jedis = new Jedis("127.0.0.1");
		String s = jedis.get("user_"+id);
		Gson gson = new Gson();
		User user = gson.fromJson(s, User.class);
		System.out.println(user.getId() + " " + user.getName() + " "+ user.getPassword());
		jedis.close();
	}
	/**
	 * 下面这个东西:将演示从数据库到Redis之间数据库的交互 
	 */
	@Test
	public void test3() {
		int id = 10;
		User user = null;
		String key = "user_"+id;
		user = (User) redisTemplate.opsForValue().get(key);
		
		if(user == null) {
			System.out.println("从数据库查询:" + key);
//			user = 
		}
	}
}
