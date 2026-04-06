package org.example.gorest.generator;

import com.github.javafaker.Faker;
import org.example.gorest.models.User;


public class UserGenerator {

    private static final Faker faker = new Faker();

    public static User randomUser(){
        return User.builder()
                .name(faker.name().fullName())
                .email(generateEmail())
                .gender(randomGender())
                .status("active")
                .build();
    }

    private static String generateEmail() {
        return faker.internet().emailAddress();
    }

    private static String randomGender() {
        return faker.options().option("male", "female");
    }
}
