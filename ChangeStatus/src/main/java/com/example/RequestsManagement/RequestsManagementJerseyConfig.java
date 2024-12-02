package com.example.RequestsManagement;

import com.example.RequestsManagement.Services.RequestsManagementWebService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestsManagementJerseyConfig extends ResourceConfig {
    public RequestsManagementJerseyConfig() {
        register(RequestsManagementWebService.class);
    }
}
