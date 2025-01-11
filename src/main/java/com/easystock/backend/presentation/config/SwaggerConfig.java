package com.easystock.backend.presentation.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@Configuration
public class SwaggerConfig {
    private static Components authComponent() {
        return new Components().addSecuritySchemes("session-token",
                new SecurityScheme()
                        .type(SecurityScheme.Type.APIKEY)
                        .in(SecurityScheme.In.HEADER)
                        .name("Authorization"));
    }
    @Bean
    public OpenAPI RingleAPI() {
        Info info = new Info()
                .title(" EASY STOCK API")
                .description("""
                        ###  이화 캡스톤프로젝트 이지스톡 REST API 명세 문서입니다.
                        - #### 자물쇠 버튼으로 `Authorization` 헤더 설정이 가능합니다.
                        """)
                .version("v0.1");
        return new OpenAPI()
                .info(info)
                .components(authComponent());
    }
}
