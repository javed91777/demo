import courgette.api.*;
import courgette.api.junit.Courgette;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ui_tests.utilities.UiHelperMethods;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 1,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        rerunAttempts = 1,
        testOutput = CourgetteTestOutput.CONSOLE,
        reportTitle = "Courgette-JVM Example",
        reportTargetDir = "build",
        plugin = CourgettePlugin.EXTENT_REPORTS,
        //environmentInfo = "browser=chrome; git_branch=master",
        //classPath = {"build/libs/*","build/classes/java/test"},
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "ui_tests.stepDefinitions",
                tags = "@LoginTest",
                publish = false,
                plugin = {
                        "pretty",
                        "json:build/cucumber-report/cucumber.json",
                        "html:build/cucumber-report/cucumber.html",
                        "junit:build/cucumber-report/cucumber.xml"}
        ))
public class CucumberRunner {
}
