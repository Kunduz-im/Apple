package org.example.demoQA.helpers;

import org.example.demoQA.drivers.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    private WebDriver driver = DriverManager.getDriver();

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    private Alert getAlert(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert(); //с html переключается к Alert, т.к. он не элемент DOMа
    }

    public void accept(){ //принять
        getAlert().accept(); //метод который нажимает на OK , если том есть только OK
    }

    public void dismiss(){ //отклонить
        getAlert().dismiss(); //метод который нажимает на Отмена , если том есть
    }

    public AlertHelper sendKeys(String massage){
        getAlert().sendKeys(massage);
        return this;
    }
}
