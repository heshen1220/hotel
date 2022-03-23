package com.heshen.config;

public interface BaseErrorInfoInterface {
    /**
     * 状态码
     * @return
     */
    String getCode();

    /**
     * 状态描述
     */
    String getMsg();
}
