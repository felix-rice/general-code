package com.felix.general.code.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-07-30
 */
@SpringBootApplication(scanBasePackages = {
        "com.felix.general.code.api",
        "com.felix.general.code.component",
        "com.felix.general.code.core",
        "com.felix.general.code.sdk"
})
public class GeneralCodeApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeneralCodeApiApplication.class);
    }
}