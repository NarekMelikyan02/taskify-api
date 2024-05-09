package com.example.taskifyapi.config;

import com.example.taskifyapi.service.event.handlers.EventHandlerFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public ServiceLocatorFactoryBean eventHandlerFactoryBean() {
    final ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
    serviceLocatorFactoryBean.setServiceLocatorInterface(EventHandlerFactory.class);
    return serviceLocatorFactoryBean;
  }

  @Bean
  public EventHandlerFactory eventHandlerFactory() {
    return (EventHandlerFactory) eventHandlerFactoryBean().getObject();
  }
}
