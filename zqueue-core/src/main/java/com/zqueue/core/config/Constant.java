package com.zqueue.core.config;

public class Constant {
	/**
	 * 工作队列
	 */
	public static final String WORK_QUEUE_NAME = "workqueue";
	/**
	 * 备份线程
	 */
	public static final String BACKUP_QUEUE_NAME= "backupqueue";
	
	/**
	 * 默认队列模式
	 */
	public static final String MODLE_DEFAULT = "default";
	/**
	 * 队列安全模式
	 */
	public static final String MODLE_SAFE = "safe";
	
	/**
	 * 唯一线程前缀
	 */
	public static final String UNIQUE_SUFFIX = ":unique";
	
	
	
    /**
     * 标记任务为正常执行状态
     */
    public static final String STATUS_NORMAL = "normal";

    /**
     * 标记任务为重试执行状态
     */
    public static final String STATUS_RETRY = "retry";
}
