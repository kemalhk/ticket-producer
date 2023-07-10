package com.example.TicketProducer.producer;

import com.example.TicketProducer.model.Ticket;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class TicketProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;


    @PostConstruct
    public void init(){

        Ticket ticket = new Ticket();
        ticket.setName("Test");
        ticket.setLastName("Test-LastName");
        ticket.setMail("test-mail");
        ticket.setPrice(1.1);
        ticket.setTicketNumber(1);

        sendToQueue(ticket);

    }

    public void sendToQueue(Ticket ticket){
        System.out.println("Notification Sent Name :  " + ticket.getName());
        rabbitTemplate.convertAndSend(exchangeName,routingName,ticket);
    }
}
