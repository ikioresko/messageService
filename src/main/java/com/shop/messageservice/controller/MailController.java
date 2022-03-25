package com.shop.messageservice.controller;

import com.shop.messageservice.model.Message;
import com.shop.messageservice.service.MailSender;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller that send any messages
 */
@RestController
public class MailController {
    private final MailSender mailSender;

    public MailController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping("/send")
    public void send(@RequestBody @Valid Message message){
        mailSender.send(message.getEmail(), message.getSubject(), message.getText());
    }
}
