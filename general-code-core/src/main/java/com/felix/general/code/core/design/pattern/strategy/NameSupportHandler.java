package com.felix.general.code.core.design.pattern.strategy;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-13
 */
public interface NameSupportHandler<T> extends BaseSupportHandler<T> {
    String name();

    @Override
    default boolean support(T t) {
        return false;
    }

    @Override
    default boolean isDefault() {
        return false;
    }
}
