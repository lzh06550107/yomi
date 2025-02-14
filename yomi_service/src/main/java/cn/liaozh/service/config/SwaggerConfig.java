package cn.liaozh.service.config;

import com.google.common.base.Predicates;
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
    public SwaggerConfig() {
    }

    @Bean
    public Docket api() {
        return (new Docket(DocumentationType.SWAGGER_2)).apiInfo(this.apiInfo()).pathMapping("/").select().apis(RequestHandlerSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error.*"))).paths(PathSelectors.regex("/.*")).build();
    }

    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder()).title("悠米校园接口文档").contact(new Contact("Xuan", "", "xxx@qq.com")).description("SWAGGER_2接口文档").termsOfServiceUrl("NO terms of service").license("The Apache License, Version 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("v1.0").build();
    }
}
