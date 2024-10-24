package com.tad.b1;

import com.tad.b1.controller.WorkerController;
import com.tad.b1.resources.JavaEE8Resource;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application.
 * @author Juneau
 */
@ApplicationPath("/resources")
public class JAXRSConfiguration extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    
    public JAXRSConfiguration() {
        singletons.add(new WorkerController());
        singletons.add(new JavaEE8Resource());
    }
    
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }

    @Override
    public Map<String, Object> getProperties() {
        return super.getProperties();
    }
    
}
