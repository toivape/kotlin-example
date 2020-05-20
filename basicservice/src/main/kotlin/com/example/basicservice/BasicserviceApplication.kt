package com.example.basicservice

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

private val logger = KotlinLogging.logger {}

@SpringBootApplication
class BasicserviceApplication {

    @Bean
    fun messageSource(): MessageSource {
        logger.info { "Initializing MessageSource" }
        val messageSource = ReloadableResourceBundleMessageSource()
        messageSource.setBasename("classpath:messages")
        messageSource.setDefaultEncoding("UTF-8")
        return messageSource
    }

    /**
     * Validator factory is used to get validation error messages from messages.properties.
     * See also {@link com.example.basicservice.controller.RestExceptionHandler}.
     */
    @Bean
    fun validatorFactory(messageSource: MessageSource): LocalValidatorFactoryBean {
        logger.info { "Initializing LocalValidatorFactoryBean. Using message source $messageSource" }
        val bean = LocalValidatorFactoryBean()
        bean.setValidationMessageSource(messageSource())
        return bean
    }
}

fun main(args: Array<String>) {
    runApplication<BasicserviceApplication>(*args)
}
