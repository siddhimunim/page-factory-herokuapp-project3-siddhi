package com.herokuapp.internet.pages;

import com.aventstack.extentreports.Status;
import com.herokuapp.internet.customlisteners.CustomListeners;
import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(name = "username")
    WebElement userName ;

    @CacheLookup
    @FindBy(xpath ="//input[@id='password']")
    WebElement password ;
    @CacheLookup
    @FindBy(xpath ="//body/div[2]/div[1]/div[1]/form[1]/button[1]")
    WebElement loginLink ;
    @CacheLookup
    @FindBy(xpath ="//div[@id='flash']")
    WebElement verifyInvalidUserName  ;
    @CacheLookup
    @FindBy(xpath ="//div[@id='flash']")
    WebElement verifyInvalidPassword  ;



    public void enterUsername1(String name){
        Reporter.log("click on username " + userName.toString() );
        sendTextToElement(userName,name);
        CustomListeners.test.log(Status.PASS, "enter username: " + name);

    }
    public void enterPassword(String pass){

        Reporter.log("click on password " + password.toString() );
        sendTextToElement(password,pass);
        CustomListeners.test.log(Status.PASS, "enter password: " + pass);
    }
    public void clickOnLogin(){
        Reporter.log("click on login " + loginLink.toString() );
        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS, "click on login: " );

    }
    public String varifyInvalidName(){
        Reporter.log("verify invalid Name  " + verifyInvalidUserName.toString() );
        CustomListeners.test.log(Status.PASS, "verify invalid Name " );
        return getTextFromElement(verifyInvalidUserName);

    }
    public String varifyInvalidPassword(){
        Reporter.log("verify invalid password  " + verifyInvalidUserName.toString() );
        return getTextFromElement(verifyInvalidPassword);

    }



}
