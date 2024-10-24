
package com.tad.b2.service;

import com.tad.b2.dto.ChangeOrganizationRequest;
import com.tad.b2.dto.ChangeStatusRequest;
import com.tad.b2.entity.Organization;
import com.tad.b2.entity.enums.Status;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
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
    
    private static String FIRE_REQUEST_URL = "http://127.0.0.1:8080/b1-1.0/resources/workers/status";
    private static String MOVE_REQUEST_URL = "http://127.0.0.1:8080/b1-1.0/resources/workers/org";
    
//    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad-node2");
//    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    Client client = ClientBuilder.newClient();

    public Response fireEmployee(long emId) {
        
        WebTarget target = client.target(FIRE_REQUEST_URL );
        
        ChangeStatusRequest data = new ChangeStatusRequest(emId, Status.FIRED);
        
        Entity entity = Entity.entity(data, MediaType.APPLICATION_XML);
        
        Response response = target.request().put(entity);
        
        return response;
    }
    
    public Response moveEmployee(long userId, long fromOrgId, long toOrgId) {
        try{
//            begin();
            
//            Organization fromOrg = entityManager.find(Organization.class, fromOrgId);
//            
//            if(fromOrg == null) 
//                return Response.status(500).build();
//            
//            Organization toOrg = entityManager.find(Organization.class, toOrgId);
//            
//            if(toOrg == null) 
//                return Response.status(500).build();
            
            WebTarget target = client.target(MOVE_REQUEST_URL );

            ChangeOrganizationRequest data = new ChangeOrganizationRequest(userId, toOrgId);

            Entity entity = Entity.entity(data, MediaType.APPLICATION_XML);

            Response response = target.request().put(entity);

            return response;           
        } catch (Exception e) {
            
        }
        
        return Response.status(503).build();
    }
    
//    public EntityManager getManager() {
//        return this.entityManager;
//    }
//
//    public void begin() {
//        entityManager.getTransaction().begin();
//    }
//
//    public void commit() {
//        entityManager.getTransaction().commit();
//    }
//    
//    public void rollback() {
//        entityManager.getTransaction().rollback();
//    }
}
