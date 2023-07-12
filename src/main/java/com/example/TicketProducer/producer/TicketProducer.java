package com.example.TicketProducer.producer;

import com.example.TicketProducer.model.Ticket;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;


@Service
public class TicketProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${ticket.rabbitmq.routingkey}")
    private String routingKey;


//    @PostConstruct
//    public void init(){
//        Ticket ticket = new Ticket();
//        ticket.setId(1);
//        ticket.setName("Test");
//        ticket.setLastName("Test-LastName");
//        ticket.setMail("test-mail");
//        ticket.setPrice(1.1);
//        ticket.setTicketNumber(1);
//
//        sendToQueue(ticket);
//
//    }

    public  void ticketCreate()
    {
        Ticket ticket = new Ticket();
        ticket.setName("redis-cache-test-name");
        ticket.setLastName("Test-LastName");
        ticket.setMail("test-mail");
        ticket.setPrice(1.1);
        ticket.setTicketNumber(1);
        sendToQueue(ticket);
    }

    public void sendToQueue(Ticket ticket){
        System.out.println("Notification Sent Name :  " + ticket.getName());
        rabbitTemplate.convertAndSend(routingKey,ticket);
    }
}
