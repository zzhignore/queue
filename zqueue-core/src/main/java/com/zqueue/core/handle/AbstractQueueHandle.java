package com.zqueue.core.handle;

import com.zqueue.core.entity.Task;

/**
 * 队列操作类
 * @author zzh
 * @date 2018/3/19
 */
public abstract class AbstractQueueHandle {
	/**
	 * 任务入栈
	 * @param task
	 */
	public abstract void pushTask(Task task);
	/**
	 * 任务出栈
	 * @return
	 */
	public abstract Task popTask();
	
}
