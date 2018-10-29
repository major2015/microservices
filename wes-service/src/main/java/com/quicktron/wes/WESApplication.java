package com.quicktron.wes;

import com.quicktron.wes.db.WESDataMock;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月27日 23:12
 */
@RestController
@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class WESApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(WESApplication.class).run();
    }

    @Bean
    public Docket swaggerPersonApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.quicktron.wes.resources"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("wes API").description("Documentation Employee API v1.0").build());
    }

    @Bean
    WESDataMock initWESDataMock() {
        return new WESDataMock();
    }
}
