package ru.leha.SpringRESTfull;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Settings for Swagger.
 *
 * @author Aleksei Agishev
 * @version 1.0
 */
@Configuration
public class SpringFoxConfig {
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringRESTfullApplication API Documentation")
                .description("Describes available methods for RESTControllers")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.leha.SpringRESTfull.rest"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}
