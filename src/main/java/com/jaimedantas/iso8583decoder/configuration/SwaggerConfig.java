package com.jaimedantas.iso8583decoder.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Enables the Swagger API interface for testing this service
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ISO 8583 Decoder")
                .description("Decoder of data element 108 of the ISO 8583")
                .license("© 2022 by Jaime Dantas")
                .contact(new Contact("Jaime Dantas", "https://jaimedantas.com/", "jaimejales@hotmail.com"))
                .build();
    }

}
