package com.seeleaf.usercenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * 自定义 Swagger 接口文档配置
 *
 * @author seeleaf
 */
@Configuration
@EnableSwagger2WebMvc
public class Swagger2Config {

    @Bean(value = "dockerBean")
    public Docket dockerBean() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.seeleaf.usercenter.controller"))
//扫描路径，获取controller层的接口    .apis(RequestHandlerSelectors.basePackage("com.fourgirls.xiaoxiang.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     *
     * api 信息
     * @return
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //标题
                .title("用户中心")
                //简介
                .description("接口文档")
                //作者、网址http:localhost:8088/doc.html(这里注意端口号要与项目一致，如果你的端口号后面还加了前缀，就需要把前缀加上)、邮箱
                .contact(new Contact("seeleaf", "http:localhost:8972/api/doc.html", "2403861767@qq.com"))
                //版本
                .version("1.0")
                .build();
    }
}

