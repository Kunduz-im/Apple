package org.example.demoQA.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
//эти все вспомогательный аннотации благодаря Lombok
@AllArgsConstructor //конструктор со всеми аргументами
@NoArgsConstructor //конструктор без параметров
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE) //по умолчанию модификатор доступа всех будет приват т.к. энамка используется
public class UserPracticeForm {
     String firstName;
     String LastName;
     String email;
     String mobileNumber;
     String subject;
     String currentAddress;
     String gender;
}
