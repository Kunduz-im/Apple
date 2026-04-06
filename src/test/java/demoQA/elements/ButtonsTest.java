package demoQA.elements;

import demoQA.BaseDemoQATest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("UI")
public class ButtonsTest extends BaseDemoQATest {

    @Test
    void buttonPageTest(){
        driver.get("https://demoqa.com/buttons");
        buttonsPage.doubleClick().rightClick();

    }
}
