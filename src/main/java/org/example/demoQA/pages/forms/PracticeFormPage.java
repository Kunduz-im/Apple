package org.example.demoQA.pages.forms;

import org.example.demoQA.drivers.DriverManager;
import org.example.demoQA.models.UserPracticeForm;
import org.example.demoQA.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage() {
    }


    @FindBy(id = "firstName")
    private WebElement userFirstName;

    @FindBy(id = "lastName")
    private WebElement userLastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(css = "input[value = Male] + label")
    private WebElement maleRadioBtn;

    @FindBy(css = "input[value = Female] + label")
    private WebElement femaleRadioBtn;

    @FindBy(css = "input[value = Other] + label")
    private WebElement otherRadioBtn;

    @FindBy(id = "userNumber")
    private WebElement userMobileNumber;

    @FindBy(id = "subjectsInput")
    private WebElement userSubjects;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement userSportsBtn;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement userReadingBtn;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement userMusicBtn;

    @FindBy(id = "currentAddress")
    private WebElement userCurrentAddress;

    @FindBy(className = "btn-primary")
    private WebElement userSubmitBtn;

    @FindBy(css = ".react-datepicker__input-container")
    private WebElement datePicker;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;


    public PracticeFormPage uploadPicture(String pictureLink){
        //resources/Cat (1).jpg
        elementActions.inputText(uploadPicture, pictureLink);
        return this;
    }

    //                                                        08 Feb 2026
    public PracticeFormPage fillDateOfBirth(String dayMonthYear){
        String [] dayMonthYearParts = dayMonthYear.split(" ");
        String day = dayMonthYearParts[0];
        String month = dayMonthYearParts[1];
        String year = dayMonthYearParts[2];
        elementActions.clickBtn(datePicker);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        WebElement monthDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("react-datepicker__month-select")));
        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("react-datepicker__year-select")));

        elementActions.selectByVisibleText(monthDropdown, month );
        elementActions.selectByVisibleText(yearDropDown, year);

        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//div[contains(@class,'react-datepicker__day') and not(contains(@class,'react-datepicker__day--outside-month')) and text()='"
                        + day + "']")));
        elementActions.clickBtn(dayElement);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public PracticeFormPage fillUserFirstName(String name){
        elementActions.scrollToElement(userFirstName).inputText(userFirstName, name);
        return this;
    }

    public PracticeFormPage fillUserLastName(String lastName){
        elementActions.scrollToElement(userLastName).inputText(userLastName, lastName);
        return this;
    }

    public PracticeFormPage fillUserEmail(String email){
        elementActions.scrollToElement(userEmail).inputText(userEmail, email);
    return this;
    }

    public PracticeFormPage clickChoiceGenderBtn(String gender){
        switch (gender.toLowerCase().trim()){
            case "male":
                elementActions.scrollToElement(maleRadioBtn).clickBtn(maleRadioBtn);
                break;
            case "female":
                elementActions.scrollToElement(femaleRadioBtn).clickBtn(femaleRadioBtn);
                break;
            case "other":
                elementActions.scrollToElement(otherRadioBtn).clickBtn(otherRadioBtn);
                break;
            default:
                throw new IllegalArgumentException("Неверный пол: " + gender);
        }
        return this;
    }

    public PracticeFormPage fillUserMobileNumber(String mobileNumber){
        elementActions.scrollToElement(userMobileNumber).inputText(userMobileNumber, mobileNumber);
        return this;
    }

    public PracticeFormPage fillUserSubjects(String subject){
        elementActions.scrollToElement(userSubjects).inputText(userSubjects, subject);
        userSubjects.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage clickUserReadingBtn(){
        elementActions.scrollToElement(userReadingBtn).clickBtn(userReadingBtn);
        return this;
    }

    public PracticeFormPage clickUserMusicBtn(){
        elementActions.scrollToElement(userMusicBtn).clickBtn(userMusicBtn);
        return this;
    }

    public PracticeFormPage clickUserSportBtn(){
        elementActions.scrollToElement(userSportsBtn).clickBtn(userSportsBtn);
        return this;
    }

    public PracticeFormPage fillUserCurrentAddress(String currentAddress){
        elementActions.scrollToElement(userCurrentAddress).inputText(userCurrentAddress, currentAddress);
        return this;
    }

    public PracticeFormPage clickUserSubmitBtn(){
        elementActions.scrollToElement(userSubmitBtn).clickBtn(userSubmitBtn);
        return this;
    }

    public PracticeFormPage fillUpPracticeForm(UserPracticeForm userPracticeForm){
        fillUserFirstName(userPracticeForm.getFirstName()).fillUserLastName(userPracticeForm.getLastName())
                .fillUserEmail(userPracticeForm.getEmail())
                .clickChoiceGenderBtn(userPracticeForm.getGender()).fillUserMobileNumber(userPracticeForm.getMobileNumber())
                .fillUserSubjects(userPracticeForm.getSubject())
                .clickUserReadingBtn()
                .clickUserMusicBtn()
                .clickUserSportBtn()
                .fillUserCurrentAddress(userPracticeForm.getCurrentAddress())
                .clickUserSubmitBtn();
        return this;
    }

}
