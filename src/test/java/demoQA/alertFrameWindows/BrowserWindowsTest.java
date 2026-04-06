package demoQA.alertFrameWindows;

import demoQA.BaseDemoQATest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("UI")
public class BrowserWindowsTest extends BaseDemoQATest {

    @Test
    void browserWindowsTest(){
        driver.get("https://demoqa.com/browser-windows");
        browserWindowsPage.clickTabBtn();
        browserWindowsPage.clickTabBtn();
        browserHelper.switchWindow(2);
        browserHelper.switchToParentWindow();
    }

}
