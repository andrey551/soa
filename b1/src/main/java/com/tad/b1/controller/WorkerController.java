
package com.tad.b1.controller;

import com.tad.b1.dto.data.ChangeOrganizationRequest;
import com.tad.b1.dto.data.ChangeStatusRequest;
import com.tad.b1.dto.Wrapper.GroupNameWrapper;
import com.tad.b1.entity.Worker;
import com.tad.b1.dto.Wrapper.WorkerListWrapper;
import com.tad.b1.dto.data.ServiceResponse;
import com.tad.b1.dto.entityDto.CoordinateDTO;
import com.tad.b1.dto.entityDto.PersonDTO;
import com.tad.b1.dto.entityDto.WorkerDTO;
import com.tad.b1.entity.enums.Color;
import com.tad.b1.entity.enums.Status;
import com.tad.b1.entity.enums.WorkerParameter;
import com.tad.b1.entity.response.ServiceResponseStatus;
import com.tad.b1.service.WorkerService;
import com.tad.b1.utils.XmlService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

/**
 *
 * @author Dau Cong Tuan Anh
 */
@Path("/workers")
public class WorkerController {
    
    private WorkerService ws = new WorkerService(); 
    
    @GET
    @Path("/")
    public Response getWorkers() {
        
        ServiceResponse resp = ws.getWorkers();
        
        if(resp.getStatus() != ServiceResponseStatus.SUCCESS) 
            return Response.status(resp.getResponseCode()).build();
        
        WorkerListWrapper workers = (WorkerListWrapper)resp.getData();
        System.out.println(workers.getWorkers().size());
        System.out.println(XmlService.marshalArray(workers));
        return Response.ok(XmlService.marshalArray(workers)).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML})
    public Response getWorkers(@PathParam("id")long id) {
        
        
        ServiceResponse resp = ws.getWorkerById(id);
        
        if(resp.getStatus() != ServiceResponseStatus.SUCCESS) 
            return Response.status(resp.getResponseCode()).build();
        
        Worker worker = (Worker)resp.getData();
        
        return Response.ok(XmlService.marshal(worker)).build();
    }
    
    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML})
    public Response updateWorker(
            @PathParam(value = "id") long id,
            WorkerDTO worker) {
        List<WorkerParameter> isValid = worker.handleValidate();
        
        if(!isValid.isEmpty()) {
            String message = "<message>" + "these parameter has invalid: " + isValid.toString() +"</message>";
            return Response.status(400).entity(message).build();
        }
        ServiceResponse resp = ws.updateWorker(id, worker);
        
        return Response.status(resp.getResponseCode()).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML})
    public Response deleteWorker(@PathParam("id")long id) {
        
        ServiceResponse resp = ws.deleteWorker(id);
        
        return Response.status(resp.getResponseCode()).build();
    }
    
    @POST
    @Path("/")
    @Produces({ MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML})
    public Response addWorker(WorkerDTO worker) {
        
        List<WorkerParameter> isValid = worker.handleValidate();
        
        if(!isValid.isEmpty()) {
            String message = "<message>" + "these parameter has invalid: " + isValid.toString() +"</message>";
            return Response.status(400).entity(message).build();
        }
        ServiceResponse resp = ws.insertWorker(worker);
        
        if(resp.getStatus() != ServiceResponseStatus.SUCCESS) 
            return Response.status(resp.getResponseCode()).build();
        
        System.out.println((Worker)(resp.getData()));
        return Response.ok(
                XmlService.marshal(
                        (Worker)(resp.getData())
                )).build();
    }
    
    @GET
    @Path("low-salary/{salary}")
    @Produces({ MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML})
    public Response getLowSalary(@PathParam("salary")Integer salary) {
        if(salary == null) {
            String message = "<message> Salary is invalid! </message>";
            return Response.status(400).entity(message).build();
        }
        ServiceResponse resp = ws.getLowerSalaryWorker(salary);
        
        if(resp.getStatus() != ServiceResponseStatus.SUCCESS) 
            return Response.status(resp.getResponseCode()).build();
        
        return Response.ok(XmlService.marshalArray(
                        (WorkerListWrapper)(resp.getData())
                )).build();
    }
    
    @GET
    @Path("group-by-name")
    @Produces({ MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML})
    public Response groupByName() {
        
        ServiceResponse resp = ws.groupByName();
        
        if(resp.getStatus() != ServiceResponseStatus.SUCCESS) 
            return Response.status(resp.getResponseCode()).build();
        
        return Response.ok(
                XmlService.marshalArray(
                                (GroupNameWrapper)resp.getData()
                        )
                ).build();
    }
    
    @GET
    @Path("avg-salary")
    @Produces({ MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML})
    public Response avgSalary() {
        ServiceResponse resp = ws.getAvgSalary();
        
        if(resp.getStatus() != ServiceResponseStatus.SUCCESS) 
            return Response.status(resp.getResponseCode()).build();
        
        return Response.ok(
                        "<avg-salary>" 
                        + (Float)resp.getData() 
                        + "</avg-salary>"
        ).build();
    }
    
    @PUT
    @Path("/status")
    @Produces({ MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML})
    public Response udpateStatus(ChangeStatusRequest req) {
        
        ServiceResponse resp = ws.updateStatus(req.getId(), req.getStatus());
        
        return Response.status(resp.getResponseCode()).build();
    }
    
    @PUT
    @Path("org")
    @Produces({ MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML})
    public Response moveOrg(ChangeOrganizationRequest req) {
        
        ServiceResponse resp = ws.updateOrganization(req.getId(), req.getEmId());
        
        return Response.status(resp.getResponseCode()).build();
    }
    
    @GET
    @Path("check/{id}/{org_id}")
    public Response checkValidEmployee(@PathParam("id") Long id,
                                        @PathParam("org_id") Long org_id) {
        ServiceResponse resp = ws.isBelongToOrganization(id, org_id);
        
        return Response.status(resp.getResponseCode()).entity(resp.getData()).build();
    }
}
