package fr.bpifrance.dqops.qip.qua.formation.test.ut.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@ComponentScan(basePackages = {"fr.bpifrance.dqops.qip.qua.formation.api"})
public class ApiTestConfig {
}
