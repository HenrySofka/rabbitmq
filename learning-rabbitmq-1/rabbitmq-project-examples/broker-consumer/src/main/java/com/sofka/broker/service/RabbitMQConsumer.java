package com.sofka.broker.service;

import com.sofka.broker.dto.HelloDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "${broker.rabbitmq.queue}")
    public void recievedMessage(HelloDTO helloDTO) {
        System.out.println("Recieved Message From RabbitMQ: " + helloDTO.getName());
    }
}
