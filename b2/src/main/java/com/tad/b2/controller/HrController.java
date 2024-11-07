
package com.tad.b2.controller;

import com.tad.b2.service.HrService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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
    public Response fireEmployee(@PathParam(value = "id") long id) {
        return hs.fireEmployee(id);
    }
    
    @GET
    @Path("move/{worker-id}/{id-from}/{id-to}")
    public Response moveEmployee(@PathParam(value = "worker-id") long id,
                                 @PathParam(value = "id-from") long from,
                                 @PathParam(value = "id-to") long to) {
        return hs.moveEmployee(id, from, to);
    }
}
