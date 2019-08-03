package edu.hawaii.its.creditxfer.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile(value = { "default", "dev" })
@Configuration
@ComponentScan(basePackages = "edu.hawaii.its.creditxfer")
@PropertySource("classpath:custom.properties")
public class AppConfig {
    // Empty.
}
