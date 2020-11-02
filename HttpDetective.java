package com.oraen.yagaobox_hzu.security;


public interface HttpDetective {

    //判断目标IP的行为 决定他是否可以访问
    boolean inspection(String ip);

}
