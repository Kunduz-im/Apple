package org.example.demoQA.pages.elements;

import org.example.demoQA.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckBoxPage extends BasePage {


    @FindBy(className = "text-center")
    private WebElement pageTitle;

    @FindBy(className = "rct-icon rct-icon-expand-close")
    private WebElement dropDownBtn;

    @FindBy(className = "rct-checkbox")
    private WebElement checkBox;

    @FindBy(className = "rct-option rct-option-expand-all")
    private WebElement expandAllBtn;

    @FindBy(className = "rct-icon rct-icon-collapse-all")
    private WebElement collapseAllBtn;


}
