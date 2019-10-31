package fr.bpifrance.dqops.qip.qua.formation.test.ut.dao;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"fr.bpifrance.dqops.qip.qua.formation.dao"})
@EntityScan(basePackages = {"fr.bpifrance.dqops.qip.qua.formation.domaine.models"})
@EnableJpaRepositories(basePackages = {"fr.bpifrance.dqops.qip.qua.formation.dao","fr.bpifrance.dqops.qip.qua.formation.dao.repositories"})
public class DaoTestConfig {
}
