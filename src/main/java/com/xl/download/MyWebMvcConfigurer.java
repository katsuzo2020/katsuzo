package com.xl.download;
//
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    //资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/soft/**").addResourceLocations("file:D://迅雷下载/");
      //  registry.addResourceHandler("/static/**").addResourceLocations("file:D://迅雷下载/");
    }
//拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // registry.addInterceptor();
    }
}