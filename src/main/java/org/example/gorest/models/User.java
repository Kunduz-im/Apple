package org.example.gorest.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
// @JsonInclude говорит Джексону: "не включай поля со значением null в JSON"
// Это важно для PATCH — отправляем только те поля, которые реально заполнены
@JsonInclude(JsonInclude.Include.NON_NULL) // ← игнорирует null поля
@Builder
@EqualsAndHashCode
@Setter
@Getter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseModel{

    Integer id;
    String name;
    String email;
    String gender;
    String status;
}
