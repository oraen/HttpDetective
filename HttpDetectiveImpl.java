package com.oraen.yagaobox_hzu.security.impl;

import com.oraen.yagaobox_hzu.security.HttpDetective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


import java.util.concurrent.TimeUnit;

/*
* HttpDetective的简单 可容错性实现
 */
@Component("httpDetective")
public class HttpDetectiveImpl implements HttpDetective {


    @Autowired
    private RedisTemplate<String, Integer> intRedisTemplate;

    /**单位均为毫秒*/
    private final int RECORD_TIME = 1000;
    private final int ALLOW_TIMES = 6;
    private final int REFUSE_TIME = 180000;


    @Override
    public boolean inspection(String ip) {
        Integer times = intRedisTemplate.opsForValue().get(ip);
        if(times == null){
            System.out.println("有正常人进入");
            intRedisTemplate.opsForValue().set(ip, 1, RECORD_TIME, TimeUnit.MILLISECONDS);
            return true;
        }else{
            if(times >= ALLOW_TIMES){
                System.out.println("认定为入侵行为 拦截访问 并且禁止目标短时间内再次访问并且记录 入侵者ip"+ ip);
                intRedisTemplate.opsForValue().set(ip, ALLOW_TIMES, REFUSE_TIME, TimeUnit.MILLISECONDS);
                return false;
            }else{
                System.out.println("有可疑人进入.  "+times);
                intRedisTemplate.opsForValue().increment(ip);
                return true;
            }
        }
    }
}
