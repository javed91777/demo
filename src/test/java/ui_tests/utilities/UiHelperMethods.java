package ui_tests.utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui_tests.stepDefinitions.Hooks;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UiHelperMethods {

    static WebDriver driver;
    final Logger logger = LoggerFactory.getLogger(UiHelperMethods.class);

    public WebDriver initializeWebDriver(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jsyed101\\Documents\\Git\\demo\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        logger.info("Successfully launched the browser and opened the Application");
        return driver;
    }

    public WebDriver getDriver(){
        if(driver!=null){
            return driver;
        }else{
            return initializeWebDriver();
        }
    }

    public void waitUntilElementToBeVisible(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("Element "+element+" is visible");
        }catch (Exception e){
            logger.error("Element " +element+ " is not visible");
            Hooks.scenario.attach(takeScreenshotInBytes(), "image/png", Hooks.scenario.getName());
            Assert.fail("Element " +element+ " is not visible");
        }
    }

    public void waitUntilElementToBeClickable(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            logger.info("Element "+element+" is clickable");
        }catch (Exception e){
            logger.error("Element " +element+ " is not clickable" );
            Hooks.scenario.attach(takeScreenshotInBytes(), "image/png", Hooks.scenario.getName());
            Assert.fail("Element " +element+ " is not clickable");
        }
    }

    public void click(WebElement element){
        try{
            waitUntilElementToBeVisible(element);
            waitUntilElementToBeClickable(element);
            element.click();
            logger.info("Successfully clicked on the element "+element);
        }catch(Exception e){
            logger.error("Element " +element+ " is not clickable" );
            Hooks.scenario.attach(takeScreenshotInBytes(), "image/png", Hooks.scenario.getName());
            Assert.fail("Element " +element+ " is not clickable");
        }
    }

    public void sendKeys(WebElement element, String text){
        try{
            waitUntilElementToBeVisible(element);
            waitUntilElementToBeClickable(element);
            element.clear();
            element.sendKeys(text);
            logger.info("Successfully entered the text "+text+" in the element "+element);
        }catch (Exception e){
            logger.error("Unable to enter text "+text+" in the element "+element);
            Hooks.scenario.attach(takeScreenshotInBytes(), "image/png", Hooks.scenario.getName());
            Assert.fail("Unable to enter text "+text+" in the element "+element);
        }
    }

    public String takeScreenshot(){
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("src//test//resources//screenshots//"+getCurrentDateTime()+".png");
        try {
            FileUtils.copyFile(src, destFile);
            return destFile.getPath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] takeScreenshotInBytes(){
        byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public String getCurrentDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
