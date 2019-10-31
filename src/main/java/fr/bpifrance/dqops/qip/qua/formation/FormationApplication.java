package fr.bpifrance.dqops.qip.qua.formation;

import fr.bpifrance.dqops.qip.qua.formation.configuration.DaoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {"fr.bpifrance.dqops.qip.qua.formation" })
@Import({DaoConfig.class })
public class FormationApplication {

	public static void main(String[] args) {

		SpringApplication.run(FormationApplication.class, args);
	}

}
