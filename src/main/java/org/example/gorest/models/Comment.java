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
public class Comment extends BaseModel{

    Integer id;

    @JsonProperty("post_id")
    Integer post_id;

    String name;  // имя автора комментария
    String email;
    String body; // текст комментария


}
