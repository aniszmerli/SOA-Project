package com.example.CheckClientService;

import com.example.CheckClientService.Services.CheckClientWebService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CheckClientJerseyConfig extends ResourceConfig {
    public CheckClientJerseyConfig() {
        register(CheckClientWebService.class);
    }
}
