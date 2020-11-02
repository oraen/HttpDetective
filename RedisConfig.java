package com.oraen.yagaobox_hzu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Autowired
    RedisSerializer<Integer> intRedisSerializer;

    @Bean("intRedisTemplate")
    public RedisTemplate<String, Integer> IntRedisTemplate(RedisConnectionFactory rcf){
        RedisTemplate<String, Integer> re = new RedisTemplate();
        re.setConnectionFactory(rcf);
        re.setKeySerializer(new StringRedisSerializer());
        re.setValueSerializer(intRedisSerializer);

        return re;
    }
}
