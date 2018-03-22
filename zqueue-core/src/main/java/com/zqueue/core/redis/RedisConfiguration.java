package com.zqueue.core.redis;


/**
 * redis相关的配置信息存放
 * @author zzh
 *
 */
public class RedisConfiguration {
	/**
	 * redis ip地址
	 */
	public static String host = "127.0.0.1";
	/**
	 * 端口号
	 */
	public static int port = 6379;
	/**
     * 连接池最大分配的连接数
     */
	public static int poolMaxTotal = 100;

    /**
     * 连接池的最大空闲连接数
     */
	public static int poolMaxIdle = 10;
    /**
     * redis获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted)，如果超时就抛异常，小于零:阻塞不确定的时间，默认-1
     */
	public static long poolMaxWaitMillis = -1L;

    /**
     * 任务的存活超时时间。注意，该时间是任务从创建({@code new Task(...)})到销毁的总时间。单位：ms
     * <p>
     * 该值只针对安全队列起作用
     * <p>
     * 不设置默认为 Long.MAX_VALUE
     */
	public static long aliveTimeout = 10 * 60 * 1000;;

    
}
