package com.zqueue.core.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis构建类
 * @author zzh
 * @time 2018/3/15
 */
public class RedisBuilder {
	
	private static JedisPool jedisPool = null;
	
	public static void build() {
		JedisPoolConfig jedispoolconfig = new JedisPoolConfig();		
		jedispoolconfig.setMaxTotal(RedisConfiguration.poolMaxTotal);
		jedispoolconfig.setMaxIdle(RedisConfiguration.poolMaxIdle);
		jedispoolconfig.setMaxWaitMillis(RedisConfiguration.poolMaxWaitMillis);
        
        setJedisPool(new JedisPool(jedispoolconfig, RedisConfiguration.host, RedisConfiguration.port));
	}
	

	public static JedisPool getJedisPool() {
		if(jedisPool == null) {
			build();
		}
		return jedisPool;
	}

	public static void setJedisPool(JedisPool jedisPool) {
		RedisBuilder.jedisPool = jedisPool;
	}
	
	
	
}
