package com.zqueue.core.entity;

import com.zqueue.core.config.Constant;

public  class TaskStatus {
    /**
     * 任务状态state，normal or retry
     */
    private String state;

    /**
     * 任务生成的时间戳，每次重试不会重置
     */
    private long genTimestamp;

    /**
     * 任务执行的时间戳，每次重试时，都会在该任务从任务队列中取出后（开始执行前）重新设置为当前时间
     */
    private long excTimestamp;

    /**
     * 任务超时后重试的次数
     */
    private int retry;

    public TaskStatus() {
        this.state = Constant.STATUS_NORMAL;
        this.genTimestamp = System.currentTimeMillis();
        this.excTimestamp = 0;
        this.retry = 0;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取任务生成的时间戳，每次重试不会重置
     *
     * @return 任务生成的时间戳
     */
    public long getGenTimestamp() {
        return genTimestamp;
    }

    public void setGenTimestamp(long genTimestamp) {
        this.genTimestamp = genTimestamp;
    }

    /**
     * 获取任务执行的时间戳，每次重试时，都会在该任务从任务队列中取出后（开始执行前）重新设置为当前时间
     *
     * @return 任务的执行的时间戳
     */
    public long getExcTimestamp() {
        return excTimestamp;
    }

    public void setExcTimestamp(long excTimestamp) {
        this.excTimestamp = excTimestamp;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }
}
