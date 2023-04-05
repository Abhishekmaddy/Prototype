package e2e.runnerClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/java/e2e/riskFeatures/riskE2EFeature.feature",
        glue = {"main/java/e2e/stepDefinations"},
        plugin = {"json:ExtentReports/cucumberSanityReport.json", "html:ExtentReports/cucumberHtmlSanityReport.html", "pretty"},
        publish = true,
        dryRun = true)

public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider()
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
