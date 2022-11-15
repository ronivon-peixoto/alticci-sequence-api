package com.apps.alticci.config;

import com.apps.alticci.config.properties.AppInfo;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class OpenApiConfig {

    private AppInfo app;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title(app.getTitle())
                .description(app.getDescription())
                .version(app.getVersion())
                .contact(new Contact()
                    .name("Alticci")
                    .url("https://alticci.com")
                    .email("contact@alticci.com"))
            );
    }

}
