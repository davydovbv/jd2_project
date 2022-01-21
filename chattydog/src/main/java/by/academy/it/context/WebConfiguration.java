package by.academy.it.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.bind.support.AuthenticationPrincipalArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Configuration
@ComponentScan("by.academy.it")
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public AuthenticationPrincipalArgumentResolver authenticationPrincipalArgumentResolver(){
        return new AuthenticationPrincipalArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(authenticationPrincipalArgumentResolver());
    }

}
