package org.example.db_utils.beans;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.dbutils.BeanProcessor;
import org.example.db_utils.DB_connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Setter
@Getter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Actor {

    Integer actor_id;
    String first_name;
    String last_name;
    String last_update;

    public static List<Actor> getAllActors() throws SQLException {
        String query = "select * from actor; ";
        try (ResultSet resultSet = DB_connection.makeQuery(query)){ //try-with-resources = умный try, который сам закрывает ресурсы, ручками не надо
            return new BeanProcessor().toBeanList(resultSet, Actor.class);
        }
    }

    public static Actor getBy(String column, int value) throws SQLException {
        String query = "select * from actor where " + column + " = ?; ";
        ResultSet resultSet = DB_connection.makeQuery(query, value);
        if (!resultSet.next()){
            return  null;
        } else {
            return new BeanProcessor().toBean(resultSet, Actor.class);
        }
    }

    public static void insert(String firstName, String lastName) throws SQLException {
        String query = "INSERT INTO actor (first_name, last_name, last_update) VALUES (?, ?, NOW())";
        DB_connection.makeUpdate(query, firstName, lastName);
    }

    public static void update(int actorId, String firstName, String lastName) throws SQLException {
        String query = "UPDATE actor SET first_name = ?, last_name = ?, last_update = NOW() WHERE actor_id = ?";
        DB_connection.makeUpdate(query, firstName, lastName, actorId);
    }

    public static void delete(int actorId) throws SQLException {
        String query = "DELETE FROM actor WHERE actor_id = ?";
        DB_connection.makeUpdate(query, actorId);
    }
}
