package com.oraen.yagaobox_hzu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;

import java.nio.charset.StandardCharsets;

@Configuration
public class Serializer {

    //自定义int序列化器 使用UTF-8编码
    @Bean("intRedisSerializer")
    public RedisSerializer<Integer>  intRedisSerializer(){
        return new RedisSerializer<Integer>(){

            @Override
            public byte[] serialize(@Nullable Integer integer) throws SerializationException {
                return integer== null ? null : integer.toString().getBytes(StandardCharsets.UTF_8);
            }

            @Override
            public Integer deserialize(@Nullable byte[] bytes) throws SerializationException {
                return bytes == null ? null : Integer.valueOf(new String(bytes, StandardCharsets.UTF_8));
            }
        };
    }
}
