package com.tad.ribbon.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.UUID;

@RestController
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ping")
    public String ping() {;
        String serviceUrl = "http://client-service/api/v2/hrs/ping";
        return restTemplate.getForObject(serviceUrl, String.class);
    }

    @GetMapping("fire/{id}")
    public String fireEmployee(@RequestHeader Map<String, String> headers,
                                @PathVariable(value = "id") Long id) {
        StringBuilder headerString = new StringBuilder("Headers:\n");
        headers.forEach((key, value) -> headerString.append(key).append(": ").append(value).append("\n"));
        System.out.println("Headers: "+ headerString.toString());
        String serviceUrl = "http://client-service/api/v2/hrs/fire/" + id;
        return restTemplate.getForObject(serviceUrl, String.class);
    }

    @GetMapping("move/{worker-id}/{id-from}/{id-to}")
    public String moveEmployee(@PathParam(value = "worker-id") long id,
                                 @PathParam(value = "id-from") long from,
                                 @PathParam(value = "id-to") long to) {
        String serviceUrl = "http://client-service/api/v2/hrs/move/" + id + "/" + from + "/" + to;
        return restTemplate.getForObject(serviceUrl, String.class);
    }
}
