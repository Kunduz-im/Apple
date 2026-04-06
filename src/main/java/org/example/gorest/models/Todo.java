package org.example.gorest.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Todo extends BaseModel {

    Integer id;

    // @JsonProperty — говорит Джексону как называется поле в JSON
    // В API это поле называется "user_id", а в Java мы пишем "userId"
    @JsonProperty("user_id")
    Integer user_id;

    String title;

    @JsonProperty("due_on")
    String due_on;  // дата дедлайна

    String status; //  "pending" или "completed"

}

