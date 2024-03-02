package ui_tests.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import ui_tests.pages.BasePage;

public class HomePageSteps extends BasePage {

    @Then("User validates home page is displayed")
    public void validateHomePageLoaded(){
        Hooks.scenario.log("Validating home page is loaded");
        getHomePage().validateHomePage();
    }

    @And("User clicks on Logout button")
    public void logout(){
        Hooks.scenario.log("clicking on logout button");
        getHomePage().logout();
    }
}
