package com.zqueue.core;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.zqueue.core.config.Constant;
import com.zqueue.core.entity.Task;
import com.zqueue.core.handle.AbstractQueueHandle;
import com.zqueue.core.redis.RedisQueue;

/**
 * 用于管理分布式消息队列
 * @author zzh
 *
 */
public class QueueManager extends AbstractQueueHandle{
	private final static Logger logger = Logger.getLogger(QueueManager.class.getName());
	/**
	 * 用于存放队列
	 */
	private Map<String, Object> queueMap = new HashMap<String, Object>();
	
	/**
     * 构造方法私有化，防止外部调用
     */	
	public QueueManager() {
		
	}
	/**
	 * 队列管理初始化
	 * 1、创建任务队列 2、创建备份队列
	 */
	public void init() {
		queueMap.put(Constant.WORK_QUEUE_NAME, new RedisQueue(Constant.WORK_QUEUE_NAME)); //任务队列
		queueMap.put(Constant.BACKUP_QUEUE_NAME, new RedisQueue(Constant.WORK_QUEUE_NAME)); //备份队列
	}
	
	/**
	 * 压入队列
	 * 队列：工作队列
	 */
	@Override
	public void pushTask(Task task) {
		// TODO Auto-generated method stub
		if(task == null) {
			return;
		}
		
		if(queueMap.size() > 0) {
			RedisQueue redisqueue = (RedisQueue) queueMap.get(Constant.WORK_QUEUE_NAME);			
			redisqueue.pushTask(task);
		}
	}
	/**
	 * 弹出队列
	 * 队列：工作队列
	 */
	@Override
	public Task popTask() {
		// TODO Auto-generated method stub
		if(queueMap.size() > 0) {
			RedisQueue redisqueue = (RedisQueue) queueMap.get(Constant.WORK_QUEUE_NAME);			
			return redisqueue.popTask();
		}else {
			return null;
		}
	}
	
}
