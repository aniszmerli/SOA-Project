package com.example.ClientService.Services;

import com.example.ClientService.Classes.Client;
import com.example.ClientService.Repositories.ClientRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.awt.*;
import java.util.Optional;

@Component
@Path("service/clients")
public class ClientWebService {

    @Autowired
    ClientRepo clientRepo;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAllClients() {
        List<Client> clients = clientRepo.findAll();
        return Response.ok(clients).build();
    }


    @GET
    @Path("/{numCompte}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client GetClientByNumCompte(@PathParam("numCompte") String id) {
        Optional<Client> client = clientRepo.findById(id);
        if(client.isPresent())
            return client.get();
        else
            return null;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AddClient(Client client) {
        Client savedClient = clientRepo.save(client);
        return Response.status(Response.Status.CREATED).entity(savedClient).build();
    }

    @DELETE
    @Path("/delete/{numComte}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteClient(@PathParam("numComte") String numCompte) {
        Optional<Client> client = clientRepo.findById(numCompte);
        if (client.isPresent()) {
            clientRepo.delete(client.get());
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
