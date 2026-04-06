package org.example.demoQA.pages.alertsFrameWindows;

import org.example.demoQA.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPage extends BasePage {

    @FindBy(id = "tabButton")
    WebElement tabBtn;

    @FindBy(id = "windowButton")
    WebElement windowBtn;

    @FindBy(id = "messageWindowButton")
    WebElement messageWindowBtn;

    public BrowserWindowsPage clickTabBtn (){
        elementActions.clickBtn(tabBtn);
        return this;
    }

    public BrowserWindowsPage clickWindowBtn (){
        elementActions.clickBtn(windowBtn);
        return this;
    }

    public BrowserWindowsPage clickMessageWindowBtn (){
        elementActions.clickBtn(messageWindowBtn);
        return this;
    }
}
