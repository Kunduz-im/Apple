package org.example.demoQA.drivers;

import org.example.demoQA.utils.FileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            switch (FileReader.getValue("browser").toLowerCase()){
                case "chrome" :
                    driver =  ChromeWebDriver.loadWebDriver();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFireFoxWebDriver();
                    break;
                default: throw new IllegalArgumentException("Wrong driver name");
            }
        }
        return driver;
    }

    public static void closeDriver(){
        try {
            if (driver != null){
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e){
            System.err.println("Error while closing driver");
        }
    }


}
