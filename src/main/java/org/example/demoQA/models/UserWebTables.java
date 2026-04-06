package org.example.demoQA.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserWebTables {

    String firstName;
    String lastName;
    String age;
    String email;
    String salary;
    String department;

}
