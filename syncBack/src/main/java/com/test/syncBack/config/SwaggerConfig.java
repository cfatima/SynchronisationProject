package com.test.syncBack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.test.syncBack.rest"))
            .paths(PathSelectors.any())
            .build()
            .securitySchemes(Lists.newArrayList(apiKey()))
            .apiInfo(apiInfo());
    }

    @Bean
    SecurityScheme apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration("", "", "", "", "", ApiKeyVehicle.HEADER, "Authorization",
            ",");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Backend Rest Services")
            .description("Backend with Swagger")
            .version("1.0")
            .build();
    }
}
