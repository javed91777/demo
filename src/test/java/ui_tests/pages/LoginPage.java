package ui_tests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_tests.utilities.UiHelperMethods;

public class LoginPage extends UiHelperMethods {

    @FindBy(id = "usernam")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(className = "radius")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='example']//h2")
    WebElement headerText;

    WebDriver driver;

    public LoginPage(){
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void validateLoginPage(){
//        String text = driver.findElement(By.xpath("//div[@class='example']//h2")).getText();
        Assert.assertEquals("Login Page", headerText.getText());
    }

    public void enterUserName(){

//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        userName.sendKeys("tomsmith");
        sendKeys(userName, "tomsmith");
    }

    public void enterPassword(){

//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        password.sendKeys("SuperSecretPassword!");
        sendKeys(password, "SuperSecretPassword!");
    }

    public void clickSubmitButton(){

//        driver.findElement(By.className("radius")).click();
//        submitButton.click();
        click(submitButton);
    }

}
