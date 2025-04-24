package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/reports/html-reports.html",
                "pretty",
                "rerun:target/failedScenarios.txt"
        },
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@US001",
        dryRun = false

)

public class Runner {
}
