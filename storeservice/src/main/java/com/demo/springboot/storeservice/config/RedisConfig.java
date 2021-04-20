package com.demo.springboot.storeservice.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description redis配置
 * @date 2021/1/25 16:19
 * @see
 */
@Configuration
public class RedisConfig {


    @Autowired
    private RedisStandaloneProperties redisStandaloneProperties;

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description redisTemplate bean
     * Qualifier注解指明要注入哪个Bean
     * @date 2021/1/25 19:30
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate ret = new RedisTemplate();
        // 设置k-v 的序列化和反序列化
        //使用fastjson序列化
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        ret.setKeySerializer(fastJsonRedisSerializer);
        ret.setValueSerializer(fastJsonRedisSerializer);
        ret.setHashKeySerializer(fastJsonRedisSerializer);
        ret.setHashValueSerializer(fastJsonRedisSerializer);
        ret.setConnectionFactory(redisConnectionFactory);
        return ret;
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description redis连接工厂:standalone 单机模式
     * Primary注解，当spring中有两个相同类型bean时，选用此bean DI
     * @date 2021/1/25 16:37
     */
    @Bean
    @Primary
    public RedisConnectionFactory redisConnectionFactoryStandalone() {
        // jedis pool 池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisStandaloneProperties.getPoolMaxActive());
        poolConfig.setMaxIdle(redisStandaloneProperties.getPoolMaxIdle());
        poolConfig.setMinIdle(redisStandaloneProperties.getPoolMinIdle());
        poolConfig.setMaxWaitMillis(redisStandaloneProperties.getPoolMaxWait());
        // jedis client 配置
        JedisClientConfiguration clientConfig = JedisClientConfiguration.builder()
                .usePooling()
                .poolConfig(poolConfig)
                .and()
                .readTimeout(Duration.ofMillis(redisStandaloneProperties.getRedisTimeout()))
                .build();
        // 单机模式
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName(redisStandaloneProperties.getHost());
        redisConfig.setPort(redisStandaloneProperties.getPort());
        if (StringUtils.isNotBlank(redisStandaloneProperties.getPassword())) {
            redisConfig.setPassword(redisStandaloneProperties.getPassword());
        }
        return new JedisConnectionFactory(redisConfig, clientConfig);
    }

}
