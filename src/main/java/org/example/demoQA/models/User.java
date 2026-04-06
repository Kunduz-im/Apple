package org.example.demoQA.models;

import java.util.Objects;

public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    //чтобы сравнение происходило не по ссылке, а по значению объектов нам нужно переопределять методы
    //equals & hashcode
    //после того как мы вввызвали эти два метода через быстрые клавиши запуск вывел нам уже true
    //т.е. благодаря этому эти методы переропределились
    //всегда нужно переопределять //equals & hashcode вместе, чтобы код не ломался
    // +елси мы перегружаем методы то переопределение обязательно
    public static void main(String[] args) {
        User user1 = new User(1, "Ramis");
        User user2 = new User(1, "Ramis");
        System.out.println(user1.equals(user2)); //метод equals сравнивает ссылки если мы сравниваем объекты,
        // т.е. даже если значения верны то ответ false
    }

}
