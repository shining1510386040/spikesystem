package com.demo.springboot.storeservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description redis单机版配置属性
 * @date 2021/1/25 16:42
 * @see
 */
@Component
@ConfigurationProperties(prefix = "aliyun.redis")
public class RedisStandaloneProperties {

    /**
     * 密码
     */
    @Value("${aliyun.redis.password}")
    private String password;

    /**
     * 端口
     */
    @Value("${aliyun.redis.port}")
    private int port;
    /**
     * host
     */
    @Value("${aliyun.redis.host}")
    private String host;

    /**
     * 连接超时时间
     */
    @Value("${aliyun.redis.timeout}")
    private Integer redisTimeout;

    /**
     * 最大连接
     */
    @Value("${aliyun.redis.jedis.pool.max-active}")
    private Integer poolMaxActive;
    /**
     * 最大空闲连接
     */
    @Value("${aliyun.redis.jedis.pool.max-idle}")
    private Integer poolMaxIdle;
    /**
     * 最小空闲连接
     */
    @Value("${aliyun.redis.jedis.pool.min-idle}")
    private Integer poolMinIdle;
    /**
     * 阻塞等待
     */
    @Value("${aliyun.redis.jedis.pool.max-wait}")
    private Integer poolMaxWait;

    public Integer getRedisTimeout() {
        return redisTimeout;
    }

    public void setRedisTimeout(Integer redisTimeout) {
        this.redisTimeout = redisTimeout;
    }

    public Integer getPoolMaxActive() {
        return poolMaxActive;
    }

    public void setPoolMaxActive(Integer poolMaxActive) {
        this.poolMaxActive = poolMaxActive;
    }

    public Integer getPoolMaxIdle() {
        return poolMaxIdle;
    }

    public void setPoolMaxIdle(Integer poolMaxIdle) {
        this.poolMaxIdle = poolMaxIdle;
    }

    public Integer getPoolMinIdle() {
        return poolMinIdle;
    }

    public void setPoolMinIdle(Integer poolMinIdle) {
        this.poolMinIdle = poolMinIdle;
    }

    public Integer getPoolMaxWait() {
        return poolMaxWait;
    }

    public void setPoolMaxWait(Integer poolMaxWait) {
        this.poolMaxWait = poolMaxWait;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
