package com.zqueue.core.entity;

import java.io.Serializable;

public class Task implements Serializable{
	/**
	 * 任务实体类
	 */
	private static final long serialVersionUID = 3355942465658763338L;

	/**
     * 任务队列名称
     */
    private String queueName;

    /**
     * 任务id
     */
    private String id;

    /**
     * 任务类型
     */
    private String type;

    /**
     * 任务数据
     */
    private String data;

    /**
     * 队列任务是否唯一
     */
    private boolean unique;

    /**
     * 任务状态
     */
    private TaskStatus TaskStatus;

    
    public Task() {
    	TaskStatus taskstatus = new TaskStatus();
    	this.setTaskStatus(taskstatus);
    }
    
    public Task(String taskId) {
    	this.setId(taskId);
    }
   
    /**
     * 执行任务
     * @return
     */
    public int doTask() {
    	
    	return 0;
    }
    
    
    
   
    
	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	/**
	 * @return the unique
	 */
	public boolean isUnique() {
		return unique;
	}

	/**
	 * @param unique the unique to set
	 */
	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	/**
	 * @return the taskStatus
	 */
	public TaskStatus getTaskStatus() {
		return TaskStatus;
	}

	/**
	 * @param taskStatus the taskStatus to set
	 */
	public void setTaskStatus(TaskStatus taskStatus) {
		TaskStatus = taskStatus;
	}
    
    
    
    
    
    
}
