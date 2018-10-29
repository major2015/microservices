package com.quicktron.discovery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月25日 17:23
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {
    private static final Logger logger = LoggerFactory.getLogger(DiscoveryApplication.class);

    public static void main(String[] args) {
        logger.info("discovery service started.");
        new SpringApplicationBuilder(DiscoveryApplication.class).run();
    }
}
