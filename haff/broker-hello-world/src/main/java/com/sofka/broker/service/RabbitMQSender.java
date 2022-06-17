package com.sofka.broker.service;

import com.sofka.broker.dto.RequestHelloDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${broker.rabbitmq.exchange}")
    String exchange;

    @Value("${broker.rabbitmq.routingkey}")
    private String routingkey;

    public Mono<Void> send(RequestHelloDTO requestHelloDTO){
        rabbitTemplate.convertAndSend(exchange,routingkey,requestHelloDTO);
        return Mono.empty();
    }
}
