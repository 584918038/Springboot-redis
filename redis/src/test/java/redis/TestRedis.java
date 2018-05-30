package redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @author 徐思晗
 * @date   2018年5月29日
 * @email  xshlxx@126.com
 * @version 1.0
 */
public class TestRedis {
	
	/**
	 * jedis有两种返回值: 
	 * 	# 客户端和服务器连接正常
	 *
	 *	redis 127.0.0.1:6379> PING
	 *	PONG
     *
	 *	# 客户端和服务器连接不正常(网络不正常或服务器未能正常运行)
     *
	 *	redis 127.0.0.1:6379> PING
	 *	Could not connect to Redis at 127.0.0.1:6379: Connection refused
	 *
	 */
	@Test
	public void test1() {
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println(jedis.ping());
	}
	/**
	 * 通过字符串的方式将数据写入到Redis里面
	 */
	@Test
	public void test2() {
		Jedis jedis = new Jedis("127.0.0.1");
		long i = 10000L;
		jedis.set("i", i+"");
		jedis.set("msg1", "Hello Redis");
		jedis.set("msg2".getBytes(),"你好 Redis".getBytes());
		jedis.close();
	}
	/**
	 * 字符串读取操作
	 */
	@Test
	public void test3() {
		Jedis jedis = new Jedis("127.0.0.1");
		String str = jedis.get("msg1");
		byte[] bts = jedis.get("msg2".getBytes());
		long i = Long.parseLong(jedis.get("i"));
		String str2 = new String(bts);
		System.out.println(str);
		System.out.println(str2);
		jedis.close();
	}
}
