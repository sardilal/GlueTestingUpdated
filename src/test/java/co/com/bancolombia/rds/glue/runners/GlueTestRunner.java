package co.com.bancolombia.rds.glue.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/glue_etl.feature",
        glue = "co.com.bancolombia.rds.glue.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class GlueTestRunner {
}
