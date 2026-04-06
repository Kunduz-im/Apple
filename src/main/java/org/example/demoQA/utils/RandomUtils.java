package org.example.demoQA.utils;

import com.github.javafaker.Faker;
import org.example.demoQA.models.UserPracticeForm;

public class RandomUtils {


    private static Faker faker = new Faker();


    public static UserPracticeForm generatePracticeFormUser(){
        UserPracticeForm userPracticeForm = new UserPracticeForm();

        userPracticeForm.setFirstName(faker.name().firstName());
        userPracticeForm.setLastName(faker.name().lastName());
        userPracticeForm.setEmail(faker.internet().emailAddress());
        userPracticeForm.setGender(faker.options().option("male", "female", "other"));
        userPracticeForm.setMobileNumber(String.valueOf(faker.number().randomNumber()));
        userPracticeForm.setSubject(faker.options().option("Math", "English"));
        userPracticeForm.setCurrentAddress(faker.address().fullAddress());
        return userPracticeForm;
    }

    public static void main(String[] args) {
        UserPracticeForm userPracticeForm = generatePracticeFormUser();
        System.out.println(userPracticeForm);
    }
}
