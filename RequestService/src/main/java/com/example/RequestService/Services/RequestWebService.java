package com.example.RequestService.Services;

import com.example.RequestService.Classes.Requests;
import com.example.RequestService.Repositories.RequestRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Path("service/requests")
public class RequestWebService {

    @Autowired
    RequestRepo requestRepo;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRequests() {
        List<Requests> requests = requestRepo.findAll();
        return Response.ok(requests).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRequest(Requests request) {
        Requests savedRequest = requestRepo.save(request);
        return Response.status(Response.Status.CREATED).entity(savedRequest).build();
    }

    @GET
    @Path("/{requestid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequest(@PathParam("requestid") String requestid) {
        Optional<Requests> request = requestRepo.findById(requestid);
        return request.map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @DELETE
    @Path("/delete/{requestid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRequest(@PathParam("requestid") String requestid) {
        Optional<Requests> request = requestRepo.findById(requestid);
        if (request.isPresent()) {
            requestRepo.delete(request.get());
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
}