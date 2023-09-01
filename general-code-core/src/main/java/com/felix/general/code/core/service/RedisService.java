package com.felix.general.code.core.service;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-08-13
 */
public interface RedisService {
    boolean set(String key, String value);
}
