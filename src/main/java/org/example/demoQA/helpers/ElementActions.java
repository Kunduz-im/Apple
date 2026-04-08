package org.example.demoQA.helpers;

import org.example.demoQA.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class ElementActions {

    Actions action = new Actions(DriverManager.getDriver());
    //везде где мы используем методы класса Actions, действия должны закончиться с методом .perform();

    public ElementActions waitElementToBeClickAble(WebElement webElement) {

        new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(webElement));
        return this; //в этом случае ключ. слово this возвращает сам текущий класс

    }

    public ElementActions waitElementTobeVisible(WebElement webElement) {
        new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(webElement));
        return this;
    }

    public ElementActions clickBtn(WebElement webElement) {
        waitElementToBeClickAble(webElement);
        scrollToElement(webElement);
        webElement.click();
        return this;
    }

    public ElementActions inputText(WebElement webElement, String text) {
        waitElementTobeVisible(webElement);
        scrollToElement(webElement);
        webElement.sendKeys(text);
        return this;
    }

    public ElementActions scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        //JavascriptExecutor(у) даем возможность управлять нашим драйвером, а нашим драйвером управляет, ДрайверМенеджер
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        //element(это наш параметр в этом методе)
        //arguments[0].scrollIntoView(true) - под капотом вместо arguments[0] подставляется наш параметр element
        // и говорится .scrollIntoView(true) проскроль пока не увидишь этот элемент
        return this;
    }

    public ElementActions selectByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
        return this;
    }


    public ElementActions selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
        return this;
    }

    public ElementActions doubleClick(WebElement element) {
        waitElementTobeVisible(element);
        waitElementToBeClickAble(element);
        action.doubleClick(element).perform();
        return this;
    }

    public ElementActions rightClick(WebElement element) {
        waitElementTobeVisible(element);
        waitElementToBeClickAble(element);
        action.contextClick(element).perform();
        return this;
    }


    public WebElement waitForDynamicElement(String elementId) {
        Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .withMessage("Элемент не найден после 30 секунд ожидания");

        return wait.until(driver -> driver.findElement(By.id(elementId)));
    }
}