package com.felix.general.code.core.design.pattern.strategy;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-13
 */
public interface OrderHandler extends Comparable<OrderHandler> {
    int getOrder();
}
