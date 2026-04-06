package org.example.demoQA.pages.elements;

import org.example.demoQA.models.Employee;
import org.example.demoQA.models.UserWebTables;
import org.example.demoQA.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WebTablesPage extends BasePage {

    @FindBy(id = "addNewRecordButton")
    private WebElement addBtn;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "age")
    private WebElement age;

    @FindBy(id = "salary")
    private WebElement salary;

    @FindBy(id = "department")
    private WebElement department;

    @FindBy (id = "submit")
    private WebElement submit;

    @FindBy(className = ".rt-tr-group")
    private List<WebElement> rowsList; //10строк

    public WebTablesPage clickAdd(){
        elementActions.clickBtn(addBtn);
        return this;
    }

    public WebTablesPage fillFirstName(String name){
        elementActions.inputText(firstName,name);
        return this;
    }

    public WebTablesPage fillLastName (String name){
        elementActions.inputText(lastName,name);
        return this;
    }
    public WebTablesPage fillEmail (String name){
        elementActions.inputText(userEmail,name);
        return this;
    }

    public WebTablesPage fillAge (String ageUser){
        elementActions.inputText(age,ageUser);
        return this;
    }

    public WebTablesPage fillSalary (String name){
        elementActions.inputText(salary,name);
        return this;
    }

    public WebTablesPage fillDepartment(String name){
        elementActions.inputText(department,name);
        return this;
    }

    public WebTablesPage clickSubmit(){
        elementActions.clickBtn(submit);
        return this;
    }

    public WebTablesPage fillUpAddNewRecords(UserWebTables userWebTables){
        clickAdd().fillFirstName(userWebTables.getFirstName())
                .fillLastName(userWebTables.getLastName())
                .fillEmail(userWebTables.getEmail())
                .fillAge(userWebTables.getAge())
                .fillSalary(userWebTables.getSalary())
                .fillDepartment(userWebTables.getDepartment());
        return this;
    }



    public ArrayList<Employee> getEmployeesFromTable(){
        ArrayList<Employee> employees = new ArrayList<>();
        for (WebElement row : rowsList){
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td")); //70 элементов с 10 строками и 7 столбцами

            String firstName = cells.getFirst().getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", ""); //"[^0-9]", поменять все кроме того что начинается на 0-9, ^ - знак StartWith() и когда они внутри [], то условие становится, как все кроме
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty()
                    || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()){
                continue;
            }

//            int age = Integer.parseInt(ageText.trim());
//            int salary = Integer.parseInt(salaryText.trim());

            employees.add(new Employee(firstName, lastName, ageText, email, salaryText, department));

        }
        return employees;
    }

}

