package org.example.demoQA.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver {
    public static WebDriver driver;

    public static WebDriver loadWebDriver(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            chromeOptions.addArguments("--headless=new");  // headless режим
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            return driver;

        //В селениуме есть стратегия ожидания страницы  PageLoadStrategy
        //chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER); - ожидает появления HTML документ и взаимодействует с ними на прямую
        //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE); - вообще ничего не ждет
        //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL); - стоит по умолчанию, ожидает полной загрузки страницы
    }
}
