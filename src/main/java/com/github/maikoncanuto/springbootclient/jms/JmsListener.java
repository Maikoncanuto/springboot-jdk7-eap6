package com.github.maikoncanuto.springbootclient.jms;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.jms.client.HornetQJMSConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JmsListener {

    @Bean
    public ConnectionFactory connectionFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("host", "127.0.0.1");
        properties.put("port", "5445");

        TransportConfiguration configuration = new TransportConfiguration("org.hornetq.core.remoting.impl.netty.NettyConnectorFactory", properties);
        return new HornetQJMSConnectionFactory(false, configuration);
    }

    @Bean
    public JmsListenerContainerFactory<?> factoryJms(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

}
