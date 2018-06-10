package com.zou.concurrency1.cache;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Component
public class RedisClient {

    @Resource(name = "redisPool")
    private JedisPool jedisPool;

    public void set(String key, String value) throws Exception {

        Jedis jedis = null;

        try {
            //取得一个连接
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } finally {
            //关闭连接
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    public String get(String key) throws Exception {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }


}











