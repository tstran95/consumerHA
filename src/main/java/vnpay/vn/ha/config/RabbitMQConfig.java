//package vnpay.vn.ha.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Exchange;
//import org.springframework.amqp.core.ExchangeBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.Connection;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author sontt1
// * Date:9/22/2022
// * Time:11:17 AM
// */
//@Configuration
//@RequiredArgsConstructor
//public class RabbitMQConfig {
////    @Value("${spring.rabbitmq.queue}")
////    private String queue;
////
////    @Value("${spring.rabbitmq.exchange}")
////    private String exchange;
////
////    @Value("${spring.rabbitmq.routingkey}")
////    private String routingKey;
////
////    @Value("${spring.rabbitmq.username}")
////    private String username;
////
////    @Value("${spring.rabbitmq.password}")
////    private String password;
////
////    @Value("${spring.rabbitmq.host}")
////    private String host;
////
////    @Bean
////    Queue queue() {
////        return new Queue(queue, true);
////    }
////
////    @Bean
////    Exchange myExchange() {
////        return ExchangeBuilder.directExchange(exchange).durable(true).build();
////    }
////
////    @Bean
////    Binding binding() {
////        return BindingBuilder
////                .bind(queue())
////                .to(myExchange())
////                .with(routingKey)
////                .noargs();
////    }
////
////    @Bean
////    public ConnectionFactory connectionFactory() {
////        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
////        cachingConnectionFactory.setUsername(username);
////        cachingConnectionFactory.setPassword(password);
////        return cachingConnectionFactory;
////    }
//
////    @Bean
////    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
////        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
////        factory.setConnectionFactory(connectionFactory);
////        factory.setBatchListener(true);
////        factory.setBatchSize(2);
////        factory.setConsumerBatchEnabled(true);;
////        return factory;
////    }
//
////    @Bean
////    public MessageConverter jsonMessageConverter() {
////        return new Jackson2JsonMessageConverter();
////    }
////
////    @Bean
////    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
////        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
////        rabbitTemplate.setMessageConverter(jsonMessageConverter());
////        return rabbitTemplate;
////    }
//}
