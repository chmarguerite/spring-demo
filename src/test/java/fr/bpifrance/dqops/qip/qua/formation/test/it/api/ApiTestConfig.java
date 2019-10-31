package fr.bpifrance.dqops.qip.qua.formation.test.it.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"fr.bpifrance.dqops.qip.qua.formation"})
@EntityScan(basePackages = {"fr.bpifrance.dqops.qip.qua.formation.domaine.models"})
@EnableJpaRepositories(basePackages = {"fr.bpifrance.dqops.qip.qua.formation.dao","fr.bpifrance.dqops.qip.qua.formation.dao.repositories"})
public class ApiTestConfig {
}
