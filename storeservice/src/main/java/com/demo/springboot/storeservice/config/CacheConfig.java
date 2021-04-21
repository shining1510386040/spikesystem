package com.demo.springboot.storeservice.config;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 应用缓存配置
 * @date 2021/3/1 20:26
 * @see
 */
@Configuration
public class CacheConfig {


    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 登录token 应用缓存
     * @date 2021/3/10 17:06
     */
    @Bean("tokenCache")
    public LoadingCache<String, Object> tokenCache() {
        return Caffeine.newBuilder()
                .maximumSize(10).recordStats()
                // 写入后2小时过期
                .expireAfterWrite(2, TimeUnit.HOURS)
                .build(new CacheLoader<String, Object>() {
                    @Nullable
                    @Override
                    public Object load(@NonNull String s) throws Exception {
                        //
                        return null;
                    }
                });
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 应用缓存-本地库存
     * @date 2021/3/10 17:06
     */
    @Bean("ticketStoreCache")
    public LoadingCache<String, Object> ticketStoreCache() {
        return Caffeine.newBuilder()
                .maximumSize(10).recordStats()
                // 写入后2小时过期
                .expireAfterWrite(24, TimeUnit.HOURS)
                .build(new CacheLoader<String, Object>() {
                    @Nullable
                    @Override
                    public Object load(@NonNull String s) throws Exception {
                        // 每个秒杀服务1000 张票，部署10个服务卖出1W张票
                        return new AtomicInteger(1000);
                    }
                });
    }
}
