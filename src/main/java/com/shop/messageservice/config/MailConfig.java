package com.shop.messageservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Configuration class for smtp server
 */
import java.util.Properties;

@Configuration
public class MailConfig {
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.protocol}")
    private String protocol;
    @Value("${spring.mail.debug}")
    private String debug;
    @Value("${mail.smtp.starttls.enable}")
    private String smtp;


    @Bean
    public JavaMailSender GetMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        Properties properties = mailSender.getJavaMailProperties();
        properties.setProperty("mail.transport.protocol", protocol);
        properties.setProperty("mail.debug", debug);
        properties.setProperty("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.port", port);
        properties.setProperty("mail.smtp.starttls.enable", smtp);
        return mailSender;
    }
}
