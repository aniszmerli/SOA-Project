package com.example.CheckClientService.Services;

import com.example.CheckClientService.Classes.Clients;
import com.example.CheckClientService.Repositories.CheckClientRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Path("service/check-clients")
public class CheckClientWebService {

    @Autowired
    CheckClientRepo checkClientRepo;



    @GET
    @Path("/{num_compte}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean GetClientByNumCompte(@PathParam("num_compte") String num_compte) {
        Optional<Clients> client = checkClientRepo.findById(num_compte);
        if(client.isPresent())
            return true;
        else
            return false;
    }

}
