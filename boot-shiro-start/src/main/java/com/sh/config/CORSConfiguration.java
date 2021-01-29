package com.sh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2021/1/19.
 * /**
 * 解决跨域问题springboot所需配置
 */
@Configuration
public class CORSConfiguration {
    //    @Bean
//    public WebMvcConfigurer CORSConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedMethods("*")
//                        .allowedHeaders("*")
//                        //设置是否允许跨域传cookie
//                        .allowCredentials(true)
//                        //设置缓存时间，减少重复响应
//                        .maxAge(3600);
//            }
//        };
//    }
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
//        List<String> allowedHeaders = new ArrayList<String>();
//        allowedHeaders.add("Origin");
//        allowedHeaders.add("X-Requested-With");
//        allowedHeaders.add("Accept");
//        allowedHeaders.add("x-token");
//        allowedHeaders.add("X-Token");
//        corsConfiguration.setAllowedHeaders(allowedHeaders);
//        List<String> allowedMethod = new ArrayList<String>();
//        allowedMethod.add("OPTIONS");
//        allowedMethod.add("GET");
//        allowedMethod.add("POST");
//        allowedMethod.add("DELETE");
//        allowedMethod.add("PUT");
//        corsConfiguration.setAllowedMethods(allowedMethod);
        corsConfiguration.addAllowedMethod("*");
//        List<String> exposedHeaders = new ArrayList<String>();
//        exposedHeaders.add("x-token");
//        exposedHeaders.add("X-Token");
//        corsConfiguration.setExposedHeaders(exposedHeaders);
        corsConfiguration.addExposedHeader("x-token, X-Token");
        corsConfiguration.setMaxAge(3600L);         // 预检请求的有效期，单位为秒。
        corsConfiguration.setAllowCredentials(true);// 是否支持安全证书(必需参数)
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

}
