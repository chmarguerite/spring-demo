package fr.bpifrance.dqops.qip.qua.formation.test.it.domaine;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"fr.bpifrance.dqops.qip.qua.formation.dao"})
@EntityScan(basePackages = {"fr.bpifrance.dqops.qip.qua.formation.domaine.models"})
@EnableJpaRepositories(basePackages = {"fr.bpifrance.dqops.qip.qua.formation.dao","fr.bpifrance.dqops.qip.qua.formation.dao.repositories"})
public class DaoTestConfig {
}
