package ui_tests.e2e;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EndToEndTest {

    public static void main(String[] args){

        //launch chrome

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jsyed101\\Documents\\Git\\demo\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //launch url
        driver.get("https://the-internet.herokuapp.com/login");

        //login
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        //validation
        String welcomeText = driver.findElement(By.xpath("//h4[@class=\"subheader\"]")).getText();
        Assert.assertEquals("Welcome to the Secure Area. When you are done click logout below.", welcomeText);

        //logout
        driver.findElement(By.linkText("Logout")).click();

        //quit driver
        driver.quit();
    }
}
