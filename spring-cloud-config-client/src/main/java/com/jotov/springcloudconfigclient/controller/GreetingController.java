package com.jotov.springcloudconfigclient.controller;


import com.jotov.springcloudconfigclient.config.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
public class GreetingController {
    @Value("${my.greeting: default value}")

    private String greetingMessage;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("greetings")
    public String greeting() {
        return "my.greeting: " + greetingMessage + " db.connection: " + dbSettings.getConnection();
    }
}
