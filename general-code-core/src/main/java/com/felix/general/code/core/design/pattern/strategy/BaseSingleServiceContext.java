package com.felix.general.code.core.design.pattern.strategy;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-13
 */
public abstract class BaseSingleServiceContext<O, T extends BaseSupportHandler<O>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseSingleServiceContext.class.getSimpleName());
    @Autowired(required = false)
    protected List<T> handlers = new ArrayList<>();
    private T defaultHandler;

    @PostConstruct
    private void init() {
        for (T handler : handlers) {
            init(handler);
            // 初始化默认handler
            if (handler.isDefault()) {
                defaultHandler = handler;
                break;
            }
        }

        if (CollectionUtils.isNotEmpty(handlers)) {
            handlers = sortHandler(handlers);
        }
    }

    protected List<T> sortHandler(List<T> handlers) {
        return handlers;
    }

    protected void init(T handler) {

    }

    protected T getService(O o) {
        for (T handler : handlers) {
            if (handler.support(o) && !handler.isDefault()) {
                LOGGER.debug("find handler: {}", handler.getClass().getSimpleName());
                return handler;
            }
        }
        LOGGER.debug("cannot find handler, return default handler: {}", defaultHandler);
        return defaultHandler;
    }
}
