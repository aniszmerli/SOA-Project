package com.example.VerifRequest;

import com.example.VerifRequest.Services.VerifierRequestsWebService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VerifRequestsJerseyConfig extends ResourceConfig {
    public VerifRequestsJerseyConfig() {
        register(VerifierRequestsWebService.class);
    }
}
