package gorest.api;

import org.example.gorest.controller.CommentController;
import org.example.gorest.controller.PostController;
import org.example.gorest.controller.ToDoController;
import org.example.gorest.controller.UserController;
import org.example.gorest.generator.CommentGenerator;
import org.example.gorest.generator.PostGenerator;
import org.example.gorest.generator.UserGenerator;
import org.example.gorest.models.Comment;
import org.example.gorest.models.Post;
import org.example.gorest.models.User;
import org.example.gorest.utils.ConfigurationManager;
import org.example.gorest.utils.CsvUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("API")
public class EndToEndTest {

    static String baseUrl = ConfigurationManager.getBadeConfig().gorestBaseUrl();
    static UserController userController = new UserController(baseUrl);
    static PostController postController = new PostController(baseUrl);
    static CommentController commentController = new CommentController(baseUrl);
    static ToDoController toDoController;

    @BeforeAll
    static void innitController(){
        userController = new UserController(baseUrl);
        postController = new PostController(baseUrl);
        commentController = new CommentController(baseUrl);
        toDoController = new ToDoController(baseUrl);
    }

    @Test
    @DisplayName("E2E: create user->create post-> create comment-> create todo -> delete user")
    @Tag("E2E")
    void shouldPerformFullUserWorkflowFromCreationToDeletion(){

        User user = UserGenerator.randomUser();
        User createdUser = userController.createNewUser(user);
        Integer id = createdUser.getId();

        Post post = PostGenerator.randomPost(id);
        Post createdPost = postController.createPost(post);
        Integer post_id = createdPost.getId();

        Comment comment = CommentGenerator.randomComment(post_id);
        Comment createdCommend = commentController.createComment(comment);
        Integer comment_id = createdCommend.getId();

        userController.deleteUser(id);
        postController.deletePost(post_id);
        commentController.deleteComment(comment_id);
    }

    @Test
    @Tag("REGRESSION")
    void exportUsersToCsvTest(){
        User [] users = userController.getAllUsers();
        System.out.println("Получено пользователей: " + users.length);

        // Записываем в CSV
        CsvUtils.writeUsersToCvs(users);
    }
}
