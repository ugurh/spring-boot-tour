package com.example.introduction.interceptor;

import com.example.introduction.config.ApiConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class AppInterceptorConfig extends WebMvcConfigurerAdapter {

    final ApiInterceptor apiInterceptor;
    final ApiConfig apiConfig;

    public AppInterceptorConfig(ApiInterceptor apiInterceptor, ApiConfig apiConfig) {
        this.apiInterceptor = apiInterceptor;
        this.apiConfig = apiConfig;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiInterceptor);
        registry.addInterceptor(apiConfig.localeChangeInterceptor());
    }

}
