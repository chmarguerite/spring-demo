package fr.bpifrance.dqops.qip.qua.formation.test.ut;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"pretty","html:target/cucumber-report"},
        features = "src/test/resources/features",
        glue="fr.bpifrance.dqops.qip.qua.formation.test.ut"
)
public class RunnerFormationFeaturesTest {
}
