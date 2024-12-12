
package com.tad.b1.config;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dau Cong Tuan Anh
 */
@Component
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig() {
        register(CORSFilter.class);
        // Register JAX-RS resources (controllers)
        packages("com.tad.b1.controller");  // Automatically scans for @Path annotations
    }
}
