package org.example.demoQA.pages.elements;

import org.example.demoQA.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RadioButtonPage extends BasePage {


    @FindBy(className = "text-center")
    private WebElement pageTitle;

    @FindBy(id = "yesRadio")
    private WebElement yesRadioBtn;

    @FindBy(id = "impressiveRadio")
    private WebElement impressiveRadioBtn;

    @FindBy(id = "noRadio")
    private WebElement noRadioBtn;


}
