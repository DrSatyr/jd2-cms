package by.itacademy.pinchuk.jd2.service.config;

import by.itacademy.pinchuk.jd2.database.config.DatabaseConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("by.itacademy.pinchuk.jd2.service")
@Import(DatabaseConfig.class)
public class ServiceConfig {
}
