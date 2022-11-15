package com.apps.alticci.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.application.info")
@Getter
@Setter
public class AppInfo {

    String title;
    String description;
    String version;

}
