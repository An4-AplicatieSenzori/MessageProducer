package ro.sd.a2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AMQPConfig
{
    @Value("queue.q")
    private String queueQ;

    @Value("queue.e")
    private String queueE;

    @Value("queue.r")
    private String queueR;

    @Bean
    Queue queue()
    {
        return new Queue(queueQ, false);
    }

    @Bean
    DirectExchange exchange()
    {
        return new DirectExchange(queueE);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange directExchange)
    {
        return BindingBuilder.bind(queue).to(directExchange).with(queueR);
    }

    @Bean
    public MessageConverter jsonMessageConverter()
    {
        //ObjectMapper objectMapper = new ObjectMapper();
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

//    @Bean
//    public MessageConverter messageConverter()
//    {
//        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
//        return new Jackson2JsonMessageConverter(mapper);
//    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory)
    {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}








