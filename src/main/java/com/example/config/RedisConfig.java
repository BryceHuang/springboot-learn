package com.example.config;

import com.example.Util.FastJsonSerializerForRedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory(){
        LettuceConnectionFactory lettuceConnectionFactory=new LettuceConnectionFactory();
        return lettuceConnectionFactory;
    }

    @Bean(name = "myRedisTemplate")
    public RedisTemplate functionDomainRedisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new FastJsonSerializerForRedis<>(Object.class));
        redisTemplate.setValueSerializer(new FastJsonSerializerForRedis<>(Object.class));
        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        return redisTemplate;
    }


}
