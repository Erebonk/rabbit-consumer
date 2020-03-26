package com.ere.consumer.config;

import com.ere.consumer.domain.domain.InfoDocument;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Configuration
public class RabbitConfig {

    @Bean
    public CachingConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public MessageConverter converter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        converter.setJavaTypeMapper(new DefaultJackson2JavaTypeMapper() {

            @Override
            public JavaType toJavaType(MessageProperties properties) {
                JavaType javaType = super.toJavaType(properties);
                if (javaType instanceof CollectionLikeType) {
                    return TypeFactory.defaultInstance()
                            .constructCollectionLikeType(ConcurrentLinkedQueue.class, InfoDocument.class);
                }
                else {
                    return javaType;
                }
            }

        });
        return converter;
    }

}
