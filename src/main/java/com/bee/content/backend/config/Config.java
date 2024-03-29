package com.bee.content.backend.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = {"com.bee.content.backend"})
public class Config {

    @SuppressWarnings("rawtypes")
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters =
                new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        messageConverters.add(new org.springframework.http.converter.FormHttpMessageConverter());
        messageConverters.add(new org.springframework.http.converter.ByteArrayHttpMessageConverter());
        messageConverters.add(new org.springframework.http.converter.xml.SourceHttpMessageConverter());
        messageConverters.add(new org.springframework.http.converter.StringHttpMessageConverter());
        template.setMessageConverters(messageConverters);
        return template;
    }


    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(5000000);
        return multipartResolver;
    }

}