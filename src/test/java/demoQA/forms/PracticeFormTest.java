package demoQA.forms;

import demoQA.BaseDemoQATest;
import org.example.demoQA.models.UserPracticeForm;
import org.example.demoQA.utils.RandomUtils;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends BaseDemoQATest {

    //2 вариант
    @Test
    @Tag("SMOKE")
    void practiceFormTest1(){
        driver.get("https://demoqa.com/automation-practice-form");
        UserPracticeForm userPracticeForm = RandomUtils.generatePracticeFormUser();
        practiceFormPage.fillUpPracticeForm(userPracticeForm);
    }

    //первый вариант
    @Test
    @Tag("SMOKE")
    void practiceFormTest2(){
        driver.get("https://demoqa.com/automation-practice-form");
        UserPracticeForm userPracticeForm = new UserPracticeForm("Kunduz",
                "Imankulova", "kuki@gmail.com",
                "898989889", "Math",
                "Lissabon 89", "female");
        practiceFormPage.fillUpPracticeForm(userPracticeForm);
    }


    @Test //третий тест с календарем
    @Tag("SMOKE")
    void practiceFormTest3(){
        driver.get("https://demoqa.com/automation-practice-form");
        practiceFormPage.fillUserFirstName("Kunduz").fillUserLastName("Imankulova")
                .fillUserEmail("imk@gmail.com")
                .fillDateOfBirth("13 August 2003")
                .clickChoiceGenderBtn("female")
                .fillUserMobileNumber("+996555666444").fillUserSubjects("Math")
                .clickUserMusicBtn().clickUserReadingBtn().clickUserSportBtn()
                .uploadPicture("C:\\Users\\asus\\Documents\\Apple\\src\\test\\resources\\Cat (1).jpg")
                .fillUserCurrentAddress("Monaco 55");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
