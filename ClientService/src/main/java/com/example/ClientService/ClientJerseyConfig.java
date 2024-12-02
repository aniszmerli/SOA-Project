package com.example.ClientService;

import com.example.ClientService.Services.ClientWebService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientJerseyConfig extends ResourceConfig {
    public ClientJerseyConfig() {
        register(ClientWebService.class);
    }
}
