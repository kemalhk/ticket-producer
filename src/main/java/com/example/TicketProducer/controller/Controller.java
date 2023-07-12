package com.example.TicketProducer.controller;

import com.example.TicketProducer.producer.TicketProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor

public class Controller {
    private final TicketProducer ticketProducer;

    @GetMapping
    public String getTickets() {
        ticketProducer.ticketCreate();
        return "GET isteği başarılı!";
    }
}
