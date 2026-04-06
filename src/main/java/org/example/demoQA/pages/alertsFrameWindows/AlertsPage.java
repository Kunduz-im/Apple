package org.example.demoQA.pages.alertsFrameWindows;

import org.example.demoQA.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {


    @FindBy(id = "alertButton")
    private WebElement alertBtn;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertBtn;

    @FindBy(id = "confirmButton")
    private WebElement confirmBtn;

    @FindBy(id = "promtButton")
    private WebElement promtBtn;

    public AlertsPage clickAlertBtn(){
        elementActions.clickBtn(alertBtn);
        return this;
    }

    public AlertsPage clickTimerAlertBtn(){
        elementActions.clickBtn(timerAlertBtn);
        return this;
    }

    public AlertsPage clickConfirmAlertBtn(){
        elementActions.clickBtn(confirmBtn);
        return this;
    }


    public AlertsPage clickPromtAlertBtn(){
        elementActions.clickBtn(promtBtn);
        return this;
    }

}
