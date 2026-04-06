package demoQA;

import org.example.demoQA.drivers.DriverManager;
import org.example.demoQA.helpers.AlertHelper;
import org.example.demoQA.helpers.BrowserHelper;
import org.example.demoQA.helpers.IframeHelper;
import org.example.demoQA.pages.alertsFrameWindows.AlertsPage;
import org.example.demoQA.pages.alertsFrameWindows.BrowserWindowsPage;
import org.example.demoQA.pages.alertsFrameWindows.IFramePage;
import org.example.demoQA.pages.elements.ButtonsPage;
import org.example.demoQA.pages.elements.TextBoxPage;
import org.example.demoQA.pages.elements.WebTablesPage;
import org.example.demoQA.pages.forms.PracticeFormPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseDemoQATest {

    protected static WebDriver driver;
    protected static TextBoxPage textBoxPage ;
    protected static ButtonsPage buttonsPage;
    protected static PracticeFormPage practiceFormPage;
    protected static AlertsPage alertsPage;
    protected static AlertHelper alertHelper;
    protected static BrowserWindowsPage browserWindowsPage;
    protected static BrowserHelper browserHelper;
    protected static WebTablesPage webTablesPage;
    protected static IFramePage iFramePage;
    protected static IframeHelper iframeHelper;

    @BeforeAll
    public static void setupBrowser(){
        driver = DriverManager.getDriver();
        textBoxPage = new TextBoxPage();
        buttonsPage = new ButtonsPage();
        practiceFormPage = new PracticeFormPage();
        alertsPage = new AlertsPage();
        alertHelper = new AlertHelper(driver);
        browserWindowsPage = new BrowserWindowsPage();
        browserHelper = new BrowserHelper(driver);
        webTablesPage = new WebTablesPage();
        iFramePage = new IFramePage();
        iframeHelper = new IframeHelper(driver);
    }

    @AfterAll
    public static void tearDown(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DriverManager.closeDriver();
    }

}
