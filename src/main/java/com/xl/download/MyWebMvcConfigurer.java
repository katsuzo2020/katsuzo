package com.xl.download;
//
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

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
        InterceptorRegistration registration= registry.addInterceptor(new MyLoginInterceptors());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(

                "/",
                "/soft/*",
                "/list/cid/*",
                "/userlogin",
                "/login",
                "/download",
                "/**/*.html",            //html静态资源
                "/**/*.js",              //js静态资源
                "/**/*.css",             //css静态资源
                "/**/*.jpg",
                "/**/*.png",
                "/**/*.ico"
        );
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("进入.....拦截");
        registry.addViewController("/").setViewName("redirect:/download");
       // registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registry.addViewController("/login").setViewName("login");
    }
}