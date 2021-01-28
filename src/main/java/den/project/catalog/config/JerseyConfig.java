package den.project.catalog.config;

import den.project.catalog.controller.ProductsController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig()
    {
        register(ProductsController.class);
    }
}