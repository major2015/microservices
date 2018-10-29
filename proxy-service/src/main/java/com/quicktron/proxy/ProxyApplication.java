package com.quicktron.proxy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月28日 17:22
 */
@SpringBootApplication
@EnableZuulProxy
@EnableSwagger2
public class ProxyApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ProxyApplication.class).run();
    }
}
