package ui_tests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_tests.utilities.UiHelperMethods;

public class HomePage extends UiHelperMethods {

    @FindBy(xpath = "//h4[@class=\"subheader\"]")
    WebElement welcomeText;

    @FindBy(linkText = "Logout")
    WebElement logoutButton;

    WebDriver driver;

    public HomePage(){
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void validateHomePage(){
        //validation
//        String welcomeText = driver.findElement(By.xpath("//h4[@class=\"subheader\"]")).getText();
        Assert.assertEquals("Welcom to the Secure Area. When you are done click logout below.", welcomeText.getText());
    }

    public void logout(){
        //logout
//        driver.findElement(By.linkText("Logout")).click();
//        logoutButton.click();
        click(logoutButton);
    }
}
