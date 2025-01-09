package com.tad.node2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tad.node2.services.HrService;

import jakarta.xml.ws.Endpoint;

@SpringBootApplication
public class Node2Application {
	private static final String URL = "http://localhost:8888/hr";

	public static void main(String[] args) {
		System.out.println("Service is publicshed at: " + URL);
		Endpoint.publish(URL, new HrService());
		SpringApplication.run(Node2Application.class, args);
	}

}
