package com.tad.b2.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("jakartaee10")
public class JakartaEE10Resource {
    
    @GET
    @Path("fire/{id}")
    public Response fireEmployee(@PathParam(value = "id") long id) {
        return Response.ok().build();
    }
    
    @GET
    @Path("move/{worker-id}/{id-from}/{id-to}")
    public Response fireEmployee(@PathParam(value = "worker-id") long id,
                                 @PathParam(value = "id-from") long from,
                                 @PathParam(value = "id-to") long to) {
        return Response.ok().build();
    }
}
