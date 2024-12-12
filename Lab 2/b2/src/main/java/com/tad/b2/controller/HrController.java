
package com.tad.b2.controller;

import com.tad.b2.service.HrService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.OPTIONS;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


/**
 *
 * @author Dau Cong Tuan Anh
 */
@Path("/hrs")
public class HrController {
    private HrService hs = new HrService();
    
    
    @GET  
    @Path("fire/{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response fireEmployee(@PathParam(value = "id") long id) {
        Response resp =  hs.fireEmployee(id);
        switch (resp.getStatus()) {
            case 200:
                return Response.ok().build();
            case 400:
                return Response.status(400).build();
            default:
                return Response.status(503).build();
        }
        
    }
    
    @OPTIONS
    @Path("fire/{id}")
    public Response fireEmployee_ops(@PathParam(value = "id") long id) {
        return Response.ok().build();
        
    }
    
    @OPTIONS
    @Path("move/{worker-id}/{id-from}/{id-to}")
    public Response moveEmployee_ops(@PathParam(value = "worker-id") long id,
                             @PathParam(value = "id-from") long from,
                             @PathParam(value = "id-to") long to) {
        return Response.ok().build();
        
    }
    
    @GET
    @Path("move/{worker-id}/{id-from}/{id-to}")
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response moveEmployee(@PathParam(value = "worker-id") long id,
                                 @PathParam(value = "id-from") long from,
                                 @PathParam(value = "id-to") long to) {
        Response resp = hs.moveEmployee(id, from, to);
        switch (resp.getStatus()) {
            case 200:
                return Response.ok().build();
            case 400:
                return Response.status(400).build();
            default:
                return Response.status(503).build();
        }
    }
}
