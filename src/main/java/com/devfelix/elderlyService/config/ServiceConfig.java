package com.devfelix.elderlyService.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public Gson provideGson(){
        return new Gson();
    }
}
