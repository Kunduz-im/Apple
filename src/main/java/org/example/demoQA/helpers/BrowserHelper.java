package org.example.demoQA.helpers;

import org.example.demoQA.drivers.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {

    private WebDriver driver = DriverManager.getDriver();

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url){ //открывает типо ка get
        driver.navigate().to(url);
        //это то же самое что и метод get для открытия браузера, но благодаря этому методу история сохраняется
    }

    public void goBack(){ //т.к. после открытия знает историю может вернуться назад
        driver.navigate().back();
    }

    public void goForward(){ //вперед
        driver.navigate().forward();
    }

    public void refreshPage(){ //для обновления станицы
        driver.navigate().refresh();
    }

    public Set<String> getWindows(){
        return driver.getWindowHandles();
    }

    public void switchWindow(int index){
        LinkedList<String> windowsId = new LinkedList<>(getWindows()); // положили внутрь все id страниц,
        // которые получили с помощью метода Set getWindows
        if (index < 0 || index > windowsId.size()){
            throw new IllegalArgumentException("Invalid index " + index);
        }
        driver.switchTo().window(windowsId.get(index)); //иначе переключись на то окно индекс которого мы получили
    }

    public void switchToParentWindow(){
        LinkedList<String> windowsId = new LinkedList<>(getWindows()); // положили внутрь все id страниц,
        driver.switchTo().window(windowsId.getFirst()); //переключение на родительское окно
        //driver.switchTo().window(windowsId.get(0)); //переключение на родительское окно
    }


}
