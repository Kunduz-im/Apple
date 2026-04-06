package org.example.gorest.utils;

import com.opencsv.CSVWriter;
import org.example.gorest.models.User;


import java.io.FileWriter;
import java.io.IOException;

public class CsvUtils {

    // Путь где создастся файл — в корне проекта
    private static final String FILE_PATH = "src/test/resources/users.csv";

    public static void writeUsersToCvs(User[] users){
        try (CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH))){

            // Заголовки — первая строка таблицы
            String [] header = {"id", "name", "email", "gender", "status"};
            writer.writeNext(header);

            // Данные — каждый пользователь это одна строка
            for (User user : users){
                String [] row = {
                    String.valueOf(user.getId()),
                        user.getName(),
                        user.getEmail(),
                        user.getGender(),
                        user.getStatus()
                };
                writer.writeNext(row);
            }
            System.out.println("CSV файл создан: " + FILE_PATH);
        } catch (IOException e){
            throw new RuntimeException("Ошибка при создании CSV файла: " + e.getMessage());
        }
    }
}

//CSVWriter (умеет писать CSV формат)
//    └── FileWriter (умеет открывать и писать в файл)