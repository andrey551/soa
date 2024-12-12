package com.tad.node2rework.services;

import com.tad.node2rework.DTOs.ChangeOrganizationRequest;
import com.tad.node2rework.DTOs.ChangeStatusRequest;
import com.tad.node2rework.entities.Status;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import jakarta.ws.rs.core.Response;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.MediaType;

//import static jakarta.ws.rs.core.MediaType.APPLICATION_XML;

@Service
public class HrService {
    private static String FIRE_REQUEST_URL = "http://localhost:8090/node1/workers/status";
    private static String MOVE_REQUEST_URL = "http://localhost:8090/node1/workers/org";
    private static String CHECK_VALID_EMPLOYEE = "http://localhost:8090/node1/workers/check/";

    private static int SUCCESS = 200;

    private RestTemplate restTemplate;

    public String fireEmployee(long emId) {
        restTemplate = new RestTemplate();

        ChangeStatusRequest data = new ChangeStatusRequest(emId, Status.FIRED);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_XML);
        System.out.println(data.toString());
        HttpEntity<ChangeStatusRequest> requestEntity = new HttpEntity<>(data, headers);


        ResponseEntity<String> res = restTemplate.exchange(
                FIRE_REQUEST_URL,
                HttpMethod.PUT,
                requestEntity,
                String.class);
        System.out.println(res.toString());

        return res.getBody();
    }

    public String moveEmployee(long userId, long fromOrgId, long toOrgId) {
        restTemplate = new RestTemplate();
        ResponseEntity<String> checkValidEmployee = restTemplate.getForEntity(
                CHECK_VALID_EMPLOYEE + userId,
                String.class);
        if (checkValidEmployee.getStatusCode() != HttpStatus.OK) {
            return checkValidEmployee.getBody();
        }

        ChangeOrganizationRequest data = new ChangeOrganizationRequest(userId, toOrgId);
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_XML);

        HttpEntity<String> requestEntity = new HttpEntity<>(data.toString(), headers);
        System.out.println(data.toString());

        ResponseEntity<String> moveEmployee = restTemplate.exchange(
                MOVE_REQUEST_URL,
                HttpMethod.PUT,
                requestEntity,
                String.class);

        return moveEmployee.getBody();
    }
}


//    public Response fireEmployee(long emId) {
//        Client client = ClientBuilder.newClient();
//
//        WebTarget target = client.target(FIRE_REQUEST_URL );
//
//        ChangeStatusRequest data = new ChangeStatusRequest(emId, Status.FIRED);
//
//        Entity entity = Entity.entity(data, APPLICATION_XML);
//
//        Response response = target.request().put(entity);
//
//        return response;
//    }
//
//    public Response moveEmployee(long userId, long fromOrgId, long toOrgId) {
//        Client client = ClientBuilder.newClient();
//
//        WebTarget checkEmloyee = client.target(CHECK_VALID_EMPLOYEE + userId+ "/" + fromOrgId);
//
//        Response responseCheckEmployee = checkEmloyee.request().get();
//
//        if(responseCheckEmployee.getStatus() != SUCCESS)
//            return responseCheckEmployee;
//
//        WebTarget target = client.target(MOVE_REQUEST_URL );
//
//        ChangeOrganizationRequest data = new ChangeOrganizationRequest(userId, toOrgId);
//
//        Entity entity = Entity.entity(data, APPLICATION_XML);
//
//        Response response = target.request().put(entity);
//
//        return response;
//    }
//}
