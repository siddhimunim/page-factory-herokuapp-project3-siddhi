package com.herokuapp.internet.testsuite;

import com.herokuapp.internet.customlisteners.CustomListeners;
import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.pages.SecurePage;
import com.herokuapp.internet.tesbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    SecurePage securePage;
@BeforeMethod(alwaysRun = true)
    public void inIt(){
        loginPage = new LoginPage();
        securePage = new SecurePage();
    }
    @Test(groups = {"sanity","regression"})
    public void UserSholdLoginSuccessfullyWithValidCredentials(){

        loginPage.enterUsername1("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLogin();
        Assert.assertTrue(securePage.varifySecureArea().contains("You logged into a secure area!"));

    }
    @Test (groups = {"smoke","regression"})
    public void verifyTheUsernameErrorMessage() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.enterUsername1("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLogin();

        Assert.assertTrue(loginPage.varifyInvalidName().contains("Your username is invalid!"));

    }
    @Test (groups = {"smoke","regression"})
    public void verifyThePasswordErrorMessage() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.enterUsername1("tomsmith");
        loginPage.enterPassword("supersecret");
        loginPage.clickOnLogin();

        Assert.assertTrue(loginPage.varifyInvalidPassword().contains("Your password is invalid!"));


    }


}
