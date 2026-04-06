package org.example.demoQA.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
//эти все вспомогательный аннотации благодаря Lombok
@AllArgsConstructor //конструктор со всеми аргументами
@Builder //это шаблон проектирования строитель (эта аннотация помогает нам создавать сложные объекты)
@NoArgsConstructor //конструктор без параметров
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE) //по умолчанию модификатор доступа всех будет приват т.к. энамка используется
public class Student {
    String firstName;
    int age;
    String lastName;
    String city;
    String gender;
    String subject;


    public static void main(String[] args) {
        Student student = Student.builder().firstName("Kunduz").build();
        System.out.println(student);
    }

}
