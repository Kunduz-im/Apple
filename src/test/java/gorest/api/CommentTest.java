package gorest.api;

import org.example.gorest.controller.CommentController;
import org.example.gorest.controller.PostController;
import org.example.gorest.controller.UserController;
import org.example.gorest.generator.CommentGenerator;
import org.example.gorest.generator.PostGenerator;
import org.example.gorest.generator.UserGenerator;
import org.example.gorest.models.Comment;
import org.example.gorest.models.Post;
import org.example.gorest.models.User;
import org.example.gorest.utils.ConfigurationManager;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("API")
public class CommentTest {

    String baseUrl = ConfigurationManager.getBadeConfig().gorestBaseUrl();
    UserController userController = new UserController(baseUrl);
    PostController postController = new PostController(baseUrl);
    CommentController commentController = new CommentController(baseUrl);

    @Test
    @Tag("SMOKE")
    void getAllCommentsTest() {
       commentController.getAllComments();
    }

    @Test
    @Tag("REGRESSION")
    void fullCommentCrudTest(){
        // Comment → Post → User (иерархия зависимостей)
        User user = userController.createNewUser(UserGenerator.randomUser());
        Post post = postController.createPost(PostGenerator.randomPost(user.getId()));

        // CREATE
        Comment newComment = CommentGenerator.randomComment(post.getId());
        Comment createdComment = commentController.createComment(newComment);


        // PUT
        createdComment.setBody("Updated comment body");
        commentController.updateCommentPut(createdComment.getId(), createdComment);


        // PATCH
        Comment patchData = Comment.builder().body("Patched body only").build();
        commentController.updateCommentPatch(createdComment.getId(), patchData);


        // DELETE
        commentController.deleteComment(createdComment.getId());
        userController.deleteUser(user.getId());
        postController.deletePost(post.getId());
    }
}
