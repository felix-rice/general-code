package com.felix.general.code.core.design.pattern.strategy;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-13
 */
public interface BaseSupportHandler<T> {
    boolean support(T t);

    boolean isDefault();
}
