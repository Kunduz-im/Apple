package org.example.demoQA.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode


public class Employee {

    String firstName;
    String lastName;
    String age; //int
    String email;
    String salary; //int
    String department;

}
