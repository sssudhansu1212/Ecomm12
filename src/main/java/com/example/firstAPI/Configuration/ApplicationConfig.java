package com.example.firstAPI.Configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {
    @Bean
    public RestTemplate getRestTemplateObject(){
        return new RestTemplateBuilder().build();
    }

    // public WebClient getWebClientObject(){
    //     return new WebClientBu
    // }
}
