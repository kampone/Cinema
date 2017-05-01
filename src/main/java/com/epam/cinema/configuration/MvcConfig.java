package com.epam.cinema.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/jmp/css/**").addResourceLocations("/css/**");
        registry.addResourceHandler("/jmp/fonts/**").addResourceLocations("/fonts/**");
        registry.addResourceHandler("/jmp/js/**").addResourceLocations("/js/**");
    }
}
