package com.felix.general.code.core.design.pattern.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.felix.general.code.core.util.Safes;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import jakarta.annotation.PostConstruct;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-13
 */
public abstract class BaseNameMultiServiceContext<O, T extends NameSupportHandler<O>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseNameMultiServiceContext.class);
    @Autowired(required = false)
    private List<T> handlers = new ArrayList<>();
    private final List<T> defaultHandlers = Lists.newArrayList();
    private final Set<String> names = Sets.newHashSet();
    private final ConcurrentMap<List<String>, List<T>> concurrentHashMap = Maps.newConcurrentMap();
    @PostConstruct
    private void init() {
    for (T handle : handlers) {
        if (names.contains(handle.name())) {
        throw new RuntimeException(String.format("handler：%s name duplicate", handle.name()));
        }
        if (handle.isDefault()) {
        defaultHandlers.add(handle);
        }
        names.add(handle.name());
    }
    }

    /**
     * 获取handlers，按名称匹配返回handler,如果按名称没有匹配到，返回默认handlers
     *
     * @param name 策略名称
     * @param support 支持参数
     * @return handlers
     */
    public List<T> getService(String name, O support) {
    List<T> list = Lists.newArrayList();
    if (StringUtils.isNotEmpty(name)) {
        for (T handle : handlers) {
        if (handle.name().equals(name) && (support == null || handle.support(support))
            && !handle.isDefault()) {
            list.add(handle);
        }
        }
    }
    LOGGER.debug("获取handle：{}", list);
    if (CollectionUtils.isEmpty(list)) {
        return defaultHandlers;
    }
    return list;
    }

    /**
     * 获取handlers，按名称匹配返回handler,如果按名称没有匹配到，返回默认handlers
     *
     * @param name 策略名称
     * @return handlers
     */
    public List<T> getService(String name) {
    return concurrentHashMap.computeIfAbsent(Lists.newArrayList(name), names -> getService(name, null));
    }

    /**
     * 获取handlers，按名称匹配返回handlers,如果按名称没有匹配到，返回默认handlers
     *
     * @param names 多个名称
     * @param support 支持参数
     * @return handlers
     */
    public List<T> getService(List<String> names, O support) {
    List<T> list = Lists.newArrayList();
    Safes.of(names).stream().filter(Objects::nonNull).forEach(name -> Safes.of(handlers).forEach(t -> {
        if (name.equals(t.name()) && (support == null || t.support(support)) && !t.isDefault()) {
        list.add(t);
        }
    }));
    LOGGER.debug("获取handle 列表：{}", list);
    if (CollectionUtils.isEmpty(list)) {
        return defaultHandlers;
    }
    return list;
    }

    /**
     * 获取handlers，按名称匹配返回handlers,如果按名称没有匹配到，返回默认handlers
     *
     * @param names 多个名称
     * @return handlers
     */
    public List<T> getService(List<String> names) {
    return concurrentHashMap.computeIfAbsent(names, list -> getService(names, null));
    }

    /**
     * 获取handlers，会自动附带默认的handlers
     *
     * @param name 名称
     * @param support 支持参数
     * @return handlers
     */
    public List<T> getServiceWithDefaults(String name, O support) {
    List<T> list = Lists.newArrayList(defaultHandlers);
    if (StringUtils.isNotEmpty(name)) {
        for (T handle : handlers) {
        if (handle.name().equals(name) && (support == null || handle.support(support))
            && !handle.isDefault()) {
            list.add(handle);
        }
        }
    }
    LOGGER.debug("获取handle 列表：{}", list);
    return list;
    }

    /**
     * 获取handlers，会自动附带默认的handlers
     *
     * @param name 名称
     * @return handlers
     */
    public List<T> getServiceWithDefaults(String name) {
    return concurrentHashMap.computeIfAbsent(Lists.newArrayList(names), list -> getServiceWithDefaults(name, null));
    }

    /**
     * 获取handlers，会自动附带默认的handlers
     *
     * @param names 多个handlers
     * @param support 支持参数
     * @return handlers
     */
    public List<T> getServiceWithDefaults(List<String> names, O support) {
    List<T> list = Lists.newArrayList(defaultHandlers);
    Safes.of(names).stream().filter(Objects::nonNull).forEach(name -> Safes.of(handlers).forEach(t -> {
        if (name.equals(t.name()) && (support == null || t.support(support)) && !t.isDefault()) {
        list.add(t);
        }
    }));
    LOGGER.debug("获取handle 列表：{}", list);
    return list;
    }

    /**
     * 获取handlers，会自动附带默认的handlers
     *
     * @param names 多个handlers
     * @return handlers
     */
    public List<T> getServiceWithDefaults(List<String> names) {
    return concurrentHashMap.computeIfAbsent(names, list -> getServiceWithDefaults(names, null));
    }
}
