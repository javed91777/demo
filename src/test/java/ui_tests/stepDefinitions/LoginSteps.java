package ui_tests.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import ui_tests.pages.BasePage;

public class LoginSteps extends BasePage {

    @Given("User is on the login page")
    public void validate_LoginPage(){
        Hooks.scenario.log("Validating login page is loaded");
        getLoginPage().validateLoginPage();
    }

    @When("User enters the username {string}")
    public void enter_UserName(String userName){
        Hooks.scenario.log("Entering User name");
        getLoginPage().enterUserName();
    }

    @And("User enters the password {string}")
    public void enter_Password(String pwd){
        Hooks.scenario.log("Entering password");
        getLoginPage().enterPassword();
    }

    @And("User clicks on submit button")
    public void click_SubmitButton(){
        Hooks.scenario.log("clicking on submit button");
        getLoginPage().clickSubmitButton();
    }

}
