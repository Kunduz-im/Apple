package org.example.demoQA.pages.elements;

import org.example.demoQA.models.UserTextBox;
import org.example.demoQA.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TextBoxPage extends BasePage {

    //Page Object Model
    //Для каждой вебстраницы,
    //в java мы создаем отдельные классы и в этих классах будут только те элементы которые относятся к этой странице
    //Для каждой странице свой класс
    //Элементы хранятся как поля



    public TextBoxPage() {
    }

    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "currentAddress")
    private WebElement displayedCurrentAddress;

    @FindBy(id = "permanentAddress")
    private WebElement displayedPermanentAddress;

    @FindBy(id = "submit")
    private WebElement submitBtn;


    public TextBoxPage fillUserName(String name) {
        elementActions.inputText(userName, name);
        return this;
    }

    public TextBoxPage fillUserEmail(String email) {
        elementActions.inputText(userEmail, email);
        return this;
    }

    public TextBoxPage fillCurrentAddress(String currentAddress) {
        elementActions.inputText(this.displayedCurrentAddress, currentAddress);
        return this;
    }

    public TextBoxPage fillPermanentAddress(String permanentAddress) {
        elementActions.inputText(this.displayedPermanentAddress, permanentAddress);
        return this;
    }

    public TextBoxPage submit() {
        elementActions.clickBtn(submitBtn);
        return this;
    }

    public TextBoxPage FillUpTextBoxForm(UserTextBox userTextBox){
        fillUserName(userTextBox.getName()).fillUserEmail(userTextBox.getEmail())
                .fillCurrentAddress(userTextBox.getCurrentAddress())
                .fillPermanentAddress(userTextBox.getPermanentAddress()).submit();
        return this;
    }


}
