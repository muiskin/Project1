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
        features = {"src/test/resources/features/US_001_Registration.feature",
        "src/test/resources/features/US_002_Login.feature",
        "src/test/resources/features/US_003_AddContact.feature",
        "src/test/resources/features/US_004_EditContact.feature"},
        glue = "stepdefinitions",
//        tags = "@US004EditButtonClick",
        dryRun = false

)

public class Runner {
}
