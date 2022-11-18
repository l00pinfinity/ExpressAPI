package com.boitdroid.ExpressAPI.configs;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpressConfig {

    @Bean
    public OkHttpClient okHttpClient(){
        return new OkHttpClient();
    }
}
