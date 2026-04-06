package org.example.gorest.generator;

import com.github.javafaker.Faker;
import org.example.gorest.models.Todo;


public class TodoGenerator {

    private static final Faker faker = new Faker();

    public static Todo randomTodo(int userId){
        return Todo.builder()
                .user_id(userId)
                .title(faker.lorem().sentence())
                .due_on("2025-12-31T00:00:00.000+05:30") // формат даты который ожидает API
                .status("pending")
                .build();
    }
}
