package org.example.demoQA.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.SocketHandler;

public class FileReader {

    private static Properties properties;

    static {
        try {
            String path = "src/main/resources/App.properties";
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            System.out.println(properties); //распечатывается все ключ значения которые в APP proporties
            fileInputStream.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return properties.getProperty(key.trim());
    }

    public static void main(String[] args) {
        System.out.println(getValue("name"));
    }
}
