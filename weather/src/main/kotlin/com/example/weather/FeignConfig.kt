package com.example.weather

import feign.Logger
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients
class FeignConfig {

    /**
     * Needed to enable application.properties
     * logging.level.com.example.weather.fmi.FmiFeignClient=DEBUG
     */
    @Bean
    fun feignLoggerLevel(): Logger.Level = Logger.Level.HEADERS
}