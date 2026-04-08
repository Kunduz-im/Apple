package demoQA.elements;

import demoQA.BaseDemoQATest;
import org.example.demoQA.models.UserTextBox;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("UI")
public class TextBoxTest extends BaseDemoQATest {


    @Test
    @Tag("SMOKE")
    void textBoxTest(){
        UserTextBox userTextBox = new UserTextBox("Kunduz", "kuky@gmail.com",
                "Karaganda 85",
                "Arganty 89");
        driver.get("https://demoqa.com/text-box");
//        textBoxPage.fillUserName("Kunduz").fillUserEmail("kuki@gmail.com")
//                .fillCurrentAddress("Monaco 12").fillPermanentAddress("Tokio 89").submit();

        textBoxPage.FillUpTextBoxForm(userTextBox);
    }
}
