package org.example.demoQA.pages.alertsFrameWindows;

import org.example.demoQA.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramePage extends BasePage {


    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;

    public String getSampleHeading(){
        return sampleHeading.getText();
    }



}
