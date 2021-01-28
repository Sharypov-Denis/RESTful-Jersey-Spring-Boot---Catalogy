package den.project.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogSpringBootRestApplication {//extends SpringBootServletInitializer {

    public static void main(String[] args) {
        /*new CatalogSpringBootRestApplication()
                .configure(new SpringApplicationBuilder(CatalogSpringBootRestApplication.class))
                .run(args);

         */
        SpringApplication.run(CatalogSpringBootRestApplication.class, args);
    }
}
