package com.zqueue.core;


import org.junit.Test;

import com.zqueue.core.QueueManager;
import com.zqueue.core.entity.Task;
import com.zqueue.core.entity.TaskStatus;

/**
 * Unit test for simple App.
 */
public class ZQueueTest{
	@Test
	public void push() {
		QueueManager manage = new QueueManager();
		manage.init();
		Task task = new Task("123555");

		manage.pushTask(task);
	}
	
	@Test
	public void pop() {
		QueueManager manage = new QueueManager();
		manage.init();
		
		Task task = manage.popTask();
		System.out.println(task.getId());
	}
}
