package com.felix.general.code.core.design.pattern.strategy;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-13
 */
public abstract class BaseMultiServiceContext<O, T extends BaseSupportHandler<O>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseMultiServiceContext.class);
    @Autowired(required = false)
    protected List<T> handles = new ArrayList<>();

    public List<T> getService(O support) {
        List<T> list = new ArrayList<>();
        for (T handle : handles) {
            if (handle.support(support)) {
                list.add(handle);
            }
        }
        LOGGER.debug("find handler list：{}", list);
        return list;
    }
}
