package com.tad.b2;

import com.tad.b2.controller.HrController;
import com.tad.b2.filter.CORSFilter;
import com.tad.b2.resources.JakartaEE10Resource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("v1")
public class JakartaRestConfiguration extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    
    public JakartaRestConfiguration() {
        singletons.add(new HrController());
        singletons.add(new CORSFilter());
    }
    
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
//          return Set.of(HrController.class);
    }

    @Override
    public Map<String, Object> getProperties() {
        return super.getProperties();
    }
}
