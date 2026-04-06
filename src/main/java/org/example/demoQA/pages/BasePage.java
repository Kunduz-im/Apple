package org.example.demoQA.pages;

import org.example.demoQA.drivers.DriverManager;
import org.example.demoQA.helpers.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public ElementActions elementActions = new ElementActions();

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
