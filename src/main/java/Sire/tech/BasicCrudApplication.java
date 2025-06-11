package Sire.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(
	exclude = {
		// exclusion des dépendances de sécuririté et de de la base de donnée
		SecurityAutoConfiguration.class,
	}

)
public class BasicCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicCrudApplication.class, args);
	}

}
