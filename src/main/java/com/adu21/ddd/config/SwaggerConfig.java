package com.adu21.ddd.config;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.protocol}")
    private String protocol;

    @Value("${api.version}")
    private String version;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.description}")
    private String applicationDescription;

    @Bean
    public UiConfiguration uiConfiguration() {
        return new UiConfiguration(
                null,
                "none",
                "alpha",
                "schema",
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
                false,
                true,
                60000L);
    }

    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .protocols(Sets.newHashSet(protocol))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex(".*api.*"))
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(true)
                .ignoredParameterTypes(Error.class)
                .apiInfo(metadata());
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title(applicationName.replaceAll("\\s+", "-"))
                .description(applicationDescription)
                .version(version)
                .build();
    }
}
