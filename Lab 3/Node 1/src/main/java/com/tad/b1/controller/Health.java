package com.tad.b1.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/health")
public class Health {
    @GET
    @Path("/ping")
    public String ping() {
        return "pong";
    }
}
