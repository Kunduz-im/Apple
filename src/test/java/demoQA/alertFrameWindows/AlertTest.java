package demoQA.alertFrameWindows;

import demoQA.BaseDemoQATest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("UI")

public class AlertTest extends BaseDemoQATest {

    @Test
    void alertTest(){
        driver.get("https://demoqa.com/alerts");
        alertsPage.clickAlertBtn();
        alertHelper.accept();

        alertsPage.clickConfirmAlertBtn();
        alertHelper.dismiss();

        alertsPage.clickPromtAlertBtn();
        alertHelper.sendKeys("kuki").accept();
    }


}
