package com.example.VerifRequest.Services;

import com.example.VerifRequest.Classes.Requests;
import com.example.VerifRequest.Repositories.VerifierRequestsRepo;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("service/verifrequest")
public class VerifierRequestsWebService {

    @Autowired
    private VerifierRequestsRepo verifierRequestsRepo;


    @GET
    @Path("/{requestid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verifRequest(@PathParam("requestid") Long requestid) {
        try {
            Requests request = verifierRequestsRepo.findById(requestid).orElse(null);

            if (request != null) {
                return Response.ok("{ \"status\": \"" + request.getStatus() + "\" }", MediaType.APPLICATION_JSON).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{ \"error\": \"Request not found\" }")
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"error\": \"An error occurred: " + e.getMessage() + "\" }")
                    .build();
        }
    }
}
