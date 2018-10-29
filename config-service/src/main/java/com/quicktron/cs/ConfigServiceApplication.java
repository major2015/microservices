package com.quicktron.cs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月25日 16:57
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServiceApplication {
    private static final Logger LOGGER = LogManager.getLogger(ConfigServiceApplication.class);
    public static void main(String[] args) {
        LOGGER.info("start ...");
        new SpringApplicationBuilder(ConfigServiceApplication.class).run();
    }
}
