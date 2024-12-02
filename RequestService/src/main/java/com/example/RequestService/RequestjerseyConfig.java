package com.example.RequestService;

import com.example.RequestService.Services.RequestWebService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestjerseyConfig extends ResourceConfig {
    public RequestjerseyConfig() {
        register(RequestWebService.class);
    }
}
