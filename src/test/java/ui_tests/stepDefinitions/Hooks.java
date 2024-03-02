package ui_tests.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ui_tests.utilities.UiHelperMethods;

public class Hooks extends UiHelperMethods {

    public static Scenario scenario;

    @Before
    public void launchBrowser(Scenario testScenario){
        System.out.println("Before method");
        System.out.println("Test Scenario is "+testScenario);
        scenario = testScenario;
        System.out.println("Scenario is "+scenario);
        initializeWebDriver();
    }

    @After
    public void quitDriver(Scenario scenario){
        byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        getDriver().quit();
    }

}
