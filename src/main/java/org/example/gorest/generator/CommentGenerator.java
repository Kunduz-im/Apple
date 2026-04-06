package org.example.gorest.generator;

import com.github.javafaker.Faker;
import org.example.gorest.models.Comment;


public class CommentGenerator {

    private static final Faker faker =new Faker();

    public static Comment randomComment(int postId){
        return Comment.builder()
                .post_id(postId)
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .body(faker.lorem().paragraph())
                .build();
    }


}
