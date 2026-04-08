package demoQA.elements;

import demoQA.BaseDemoQATest;
import org.example.demoQA.models.Employee;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
@Tag("UI")
public class WebTablesTest extends BaseDemoQATest {

    @Test
    @Tag("REGRESSION")
    void  webTablesTest (){
        driver.get("https://demoqa.com/webtables");

        List<Employee> employeeList = webTablesPage.getEmployeesFromTable();
        for (Employee employee : employeeList){
            System.out.println(employee);
        }

    }

    //Домашка
//    метод _> добавить нового сотрудника && проверка если такой пользователь уже есть выдать ошибку
//    метод -> обновления существующего сотрудника
//    метод -> удалять сотрудника

}
