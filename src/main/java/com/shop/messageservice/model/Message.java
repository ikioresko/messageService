package com.shop.messageservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Component
public class Message {
    @NotBlank
    private String subject;
    @NotBlank
    private String text;
    @NotBlank
    private String email;
}
