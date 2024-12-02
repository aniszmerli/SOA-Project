package com.example.RequestsManagement.Services;

import com.example.RequestsManagement.Classes.Requests;
import com.example.RequestsManagement.Repositories.RequestsManagementRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("service/ChangeStatus")
public class RequestsManagementWebService {

    @Autowired
    private RequestsManagementRepo requestsManagementRepo;


    @PUT
    @Path("/{requestid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response changeStatus(@PathParam("requestid") Long requestid, String newStatus) {
        try {
            Requests request = requestsManagementRepo.findById(requestid).orElse(null);

        if (request != null) {
            request.setStatus(newStatus);
            requestsManagementRepo.save(request);
            return Response.ok("{ \"message\": \"Status updated successfully\", \"updatedStatus\": \"" + request.getStatus() + "\" }", MediaType.APPLICATION_JSON).build();
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
