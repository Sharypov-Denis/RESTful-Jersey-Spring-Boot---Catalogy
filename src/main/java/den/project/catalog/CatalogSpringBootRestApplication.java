package den.project.catalog;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CatalogSpringBootRestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new CatalogSpringBootRestApplication()
				.configure(new SpringApplicationBuilder(CatalogSpringBootRestApplication.class))
				.run(args);
	}

}
