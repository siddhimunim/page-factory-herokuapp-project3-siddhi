package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SecurePage extends Utility {
    @CacheLookup
    @FindBy(xpath ="//div[@id='flash']")
    WebElement verifySecureArea;
    public String varifySecureArea(){
        return getTextFromElement(verifySecureArea);
    }
}


