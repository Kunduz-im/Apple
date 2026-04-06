package org.example.gorest.generator;

import com.github.javafaker.Faker;
import org.example.gorest.models.Post;


public class PostGenerator {

    private final static Faker faker = new Faker();

    public static Post randomPost (int userId){
        return Post.builder()
                .user_id(userId)
                .title(faker.lorem().sentence())
                .body(faker.lorem().paragraph())
                .build();
    }
}
