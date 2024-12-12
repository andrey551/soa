package com.tad.node2rework.controllers;

import com.netflix.discovery.EurekaClient;
import com.tad.node2rework.services.HrService;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v2/hrs")
public class HrController {
    @Autowired
    private HrService hs;

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/ping")
    public String ping() {;
        return "Response from Service Instance: " + UUID.randomUUID().toString();
    }

    @GetMapping("fire/{id}")
    public String fireEmployee(@PathVariable(value = "id") Long id) {
        return hs.fireEmployee(id);
    }
    
    @GetMapping("move/{worker-id}/{id-from}/{id-to}")
    public String moveEmployee(@PathParam(value = "worker-id") long id,
                                 @PathParam(value = "id-from") long from,
                                 @PathParam(value = "id-to") long to) {
        return hs.moveEmployee(id, from, to);
    }
}
