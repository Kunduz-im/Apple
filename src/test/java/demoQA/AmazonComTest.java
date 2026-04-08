package demoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
@Tag("UI")
public class AmazonComTest{

    @Test
    void amazonTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.amazon.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")))
                        .sendKeys("Iphone" + Keys.RETURN);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#brandsRefinements ul li a")));

        int count = driver.findElements(By.cssSelector("#brandsRefinements ul li a")).size();

        for (int i = 0; i < count; i++) {
            List<WebElement> brands = driver.findElements(By.cssSelector("#brandsRefinements ul li a"));
            brands.get(i).click();
            wait.until(ExpectedConditions.stalenessOf(brands.get(i)));
        }
        driver.quit();
    }


    @Test
    void amazonTestGBT() { //ничего не понятно
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        By searchBox = By.id("twotabsearchtextbox");

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        driver.findElement(searchBox)
                .sendKeys("Iphone" + Keys.RETURN);

        By brandsLocator = By.cssSelector("#brandsRefinements ul li a");

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(brandsLocator));

        int count = driver.findElements(brandsLocator).size();

        for (int i = 0; i < count; i++) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(brandsLocator));
            driver.findElements(brandsLocator).get(i).click();
        }
    }

}
