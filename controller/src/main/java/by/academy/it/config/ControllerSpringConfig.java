package by.academy.it.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("controllerConfiguration")
@ComponentScan(basePackages = "by.academy.it.service")
public class ControllerSpringConfig {

}
