package com.felix.general.code.core.fiber;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-11-21
 */
public class RiceFiber {
    private static final Logger LOGGER = LoggerFactory.getLogger(RiceFiber.class);
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10_000).forEach(i -> executor.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                LOGGER.info("cur:{}", i);
                return i;
            }));
        }  // executor.close() is called implicitly, and waits
        long endTime = System.currentTimeMillis();
        LOGGER.info("using time:{}", endTime - startTime);
    }
}
