package com.zqueue.core.redis;

import java.util.List;
import java.util.logging.Logger;

import com.alibaba.fastjson.JSON;
import com.zqueue.core.config.Constant;
import com.zqueue.core.entity.Task;
import com.zqueue.core.handle.AbstractQueueHandle;
import com.zqueue.core.util.JedisUtils;

import redis.clients.jedis.Jedis;

/**
 * redis队列操作类
 * @author zzh
 * @date 2018/3/19
 */
public class RedisQueue extends AbstractQueueHandle{
	private static final Logger logger = Logger.getLogger(RedisQueue.class.getName());
	/**
	 * 数据库索引
	 */
	private static final int REDIS_DB_IDX = 0;
	/**
	 * 队列名称
	 */
	private String queueName;
	/**
	 * 队列模式
	 * DEFAULT SAFE
	 */
	private String queueModle;
	
	
	public RedisQueue() {
		// TODO Auto-generated constructor stub
		this.setQueueModle(Constant.MODLE_DEFAULT); //设置默认队列模式
	}
	
	/**
	 * 构造函数
	 * @param queueName
	 */
	public RedisQueue(String queueName) {
		// TODO Auto-generated constructor stub
		if(queueName != null) {
			this.setQueueName(queueName);
		}			
	}
	
	public RedisQueue(String queueName,String modle) {
		// TODO Auto-generated constructor stub
		if(queueName != null) {
			this.setQueueName(queueName);
		}			
		
		if(modle != null) {
			this.setQueueModle(modle);
		}
	}
	
	
	
	@Override
	public void pushTask(Task task) {
		if(task == null) {
			return;
		}
		
		Jedis jedis = null;
		
		try {
			jedis = JedisUtils.getResource(REDIS_DB_IDX);
			
			//队列安全，任务唯一
			if(this.queueModle.equals(Constant.MODLE_SAFE) & task.isUnique()) {
				long existflag = jedis.sadd(this.getQueueName() + Constant.UNIQUE_SUFFIX, task.getId());
				
				if(existflag == 0) { //为0表示存在
					return;
				}
			}
			
			
			String jsontask = JSON.toJSONString(task);
			
			jedis.lpush(this.queueName, jsontask);
			
		}catch (Exception e) {
			// TODO: handle exception
			logger.warning(e.getMessage());
		}finally {
			if(jedis != null) {
				JedisUtils.returnResource(jedis);
			}
		}
	}

	@Override
	public Task popTask() {
		// TODO Auto-generated method stub
		Jedis jedis = null;
		Task task = null;
		try {
			jedis = JedisUtils.getResource(REDIS_DB_IDX);
			
			List<String> result = jedis.brpop(0, this.getQueueName());
	        String taskjson = result.get(1);
	        
	        if(taskjson == null) {
	        	return null;
	        }
	        
	        task = JSON.parseObject(taskjson, Task.class);
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.warning(e.getMessage());
		}finally {
			if(jedis != null) {
				JedisUtils.returnResource(jedis);
			}
		}
		
		return task;
	}

	
	
	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getQueueModle() {
		return queueModle;
	}

	public void setQueueModle(String queueModle) {
		this.queueModle = queueModle;
	}
			
}
