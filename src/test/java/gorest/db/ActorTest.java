package gorest.db;
import org.example.db_utils.DB_connection;
import org.example.db_utils.beans.Actor;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;


public class ActorTest {

    @Test
    @Tag("SMOKE")
    void actorTest() throws SQLException {
        DB_connection.openConnection("dvdRental");
        Actor.getAllActors().forEach(System.out::println);
        Actor actor = Actor.getBy("actor_id", 1);
        System.out.println(actor);
    }

    @Test
    @Tag("SMOKE")
    void actorTest2() throws SQLException {
        DB_connection.openConnection("dvdRental");
        Actor.insert("Kuki", "Im");
        Actor.getAllActors().forEach(System.out::println);
    }

}
