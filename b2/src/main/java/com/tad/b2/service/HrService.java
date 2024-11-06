
package com.tad.b2.service;

import com.tad.b2.dto.ChangeOrganizationRequest;
import com.tad.b2.dto.ChangeStatusRequest;
import com.tad.b2.entity.enums.Status;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Dau Cong Tuan Anh
 */
@ApplicationScoped
public class HrService {
    
    private static String FIRE_REQUEST_URL = "https://127.0.0.1:18443/api/v1/workers/status";
    private static String MOVE_REQUEST_URL = "https://127.0.0.1:18443/api/v1/workers/org";
    private static String CHECK_VALID_EMPLOYEE = "https://127.0.0.1:18443/api/v1/workers/check/";
    
    private static int SUCCESS = 200;
    
    Client client = ClientBuilder.newClient();
    

    public Response fireEmployee(long emId) {
        
        WebTarget target = client.target(FIRE_REQUEST_URL );
        
        ChangeStatusRequest data = new ChangeStatusRequest(emId, Status.FIRED);
        
        Entity entity = Entity.entity(data, MediaType.APPLICATION_XML);
        
        Response response = target.request().put(entity);
        
        return response;
    }
    
    public Response moveEmployee(long userId, long fromOrgId, long toOrgId) {
        
        WebTarget checkEmloyee = client.target(CHECK_VALID_EMPLOYEE + userId+ "/" + fromOrgId);

        Response responseCheckEmployee = checkEmloyee.request().get();
        
        if(responseCheckEmployee.getStatus() != SUCCESS) 
            return responseCheckEmployee;
        
        WebTarget target = client.target(MOVE_REQUEST_URL );

        ChangeOrganizationRequest data = new ChangeOrganizationRequest(userId, toOrgId);

        Entity entity = Entity.entity(data, MediaType.APPLICATION_XML);

        Response response = target.request().put(entity);

        return response;            
    }
    
}
