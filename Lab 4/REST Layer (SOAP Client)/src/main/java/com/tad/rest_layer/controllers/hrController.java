package com.tad.rest_layer.controllers;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tad.node2.services.HrService;
import com.tad.node2.services.HrServiceService;

@RestController
@RequestMapping("api/v3/hrs")
public class hrController {
	
	
	
    @GetMapping("fire/{id}")
    public void fireEmployee(@PathVariable(value = "id") Long id) {
		HrServiceService hrServiceService = new HrServiceService();
		HrService hrServiceProxy = hrServiceService.getHrServicePort();
		hrServiceProxy.fireEmployee(id);
        
    }
    
    @GetMapping("move/{worker-id}/{id-from}/{id-to}")
    public void moveEmployee(@PathVariable(value = "worker-id") Long id,
    		@PathVariable(value = "id-from") Long from,
    		@PathVariable(value = "id-to") Long to) {
    	
			System.out.println("id:" + id + ", from: " + from + ", to: " + to);
			HrServiceService hrServiceService = new HrServiceService();
			HrService hrServiceProxy = hrServiceService.getHrServicePort();
			hrServiceProxy.changeOrganization(id, from, to);
    }
}
