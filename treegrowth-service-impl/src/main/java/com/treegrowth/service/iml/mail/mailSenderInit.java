package com.treegrowth.service.iml.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Properties;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Service
@EnableConfigurationProperties(MailProperties.class)
public class MailSenderInit {

    @Autowired
    private MailProperties mailProperties;

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public JavaMailSenderImpl senderInit() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        addProperties(javaMailSender);
        return javaMailSender;
    }

    private void addProperties(JavaMailSenderImpl javaMailSender) {
        Map<String, String> configProperties = mailProperties.getProperties();
        Properties properties = new Properties();
        properties.putAll(configProperties);
        javaMailSender.setJavaMailProperties(properties);
        javaMailSender.setHost(this.mailProperties.getHost());
        javaMailSender.setPort(this.mailProperties.getPort());
        javaMailSender.setUsername(this.mailProperties.getUsername());
        javaMailSender.setPassword(this.mailProperties.getPassword());
    }

}
