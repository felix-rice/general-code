package com.felix.general.code.core.design.pattern.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-13
 */
public abstract class BaseMultiOrderServiceContext<O, T extends BaseSupportHandler<O> & OrderHandler> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseMultiOrderServiceContext.class);

    @Autowired(required = false)
    private List<T> handlers = new ArrayList<>();

    public List<T> getService(O support) {
        List<T> list = new ArrayList<>();
        for (T handler : handlers) {
            if (handler.support(support)) {
                list.add(handler);
            }
        }
        LOGGER.debug("获取handle 列表：{}", list);
        // 勿修改成 OrderHandler::e.getOrder()
        // see https://stackoverflow.com/questions/27031244/lambdaconversionexception-with-generics-jvm-bug
        return list.stream().sorted(Comparator.comparing(e -> e.getOrder())).collect(Collectors.toList());
    }

}
