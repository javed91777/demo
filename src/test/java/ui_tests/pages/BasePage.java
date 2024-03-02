package ui_tests.pages;

public class BasePage {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPage getLoginPage() {
        return loginPage == null ? new LoginPage(): loginPage;
    }

    public HomePage getHomePage() {
        return homePage == null ? new HomePage(): homePage;
    }

}
