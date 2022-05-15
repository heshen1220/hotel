package com.heshen.interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author tianyuanju
 * @data 2021/11/22 15:43
 */
@Configuration
class UserInterceptorAppConfig implements WebMvcConfigurer {
    @Resource
    MyInterceptorConfig simpleIntercepter;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleIntercepter).addPathPatterns("/**").excludePathPatterns("/swagger-ui.html").excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**","/check");

    }
}
