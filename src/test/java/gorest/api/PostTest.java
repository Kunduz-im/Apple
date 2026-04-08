package gorest.api;

import org.example.gorest.controller.PostController;
import org.example.gorest.controller.UserController;
import org.example.gorest.generator.PostGenerator;
import org.example.gorest.generator.UserGenerator;
import org.example.gorest.models.Post;
import org.example.gorest.models.User;
import org.example.gorest.utils.ConfigurationManager;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("API")
public class PostTest {

    String baseUrl = ConfigurationManager.getBadeConfig().gorestBaseUrl();
    UserController userController = new UserController(baseUrl);
    PostController postController = new PostController(baseUrl);

    @Test
    @Tag("SMOKE")
    void getAllPostsTest() {
       postController.getAllPosts();
    }

    @Test
    @Tag("REGRESSION")
    void fullPostCrudTest(){
        User user = userController.createNewUser(UserGenerator.randomUser());

        // CREATE
        Post newPost = PostGenerator.randomPost(user.getId());
        Post createdPost = postController.createPost(newPost);


        // PUT
        createdPost.setTitle("Updated Post Title");
        createdPost.setBody("Updated body content");
        postController.updatePostPut(createdPost.getId(), createdPost);


        // PATCH — меняем только заголовок
        Post patchData = Post.builder().title("Patched Title Only").build();
        postController.updatePostPatch(createdPost.getId(), patchData);


        // DELETE
        postController.deletePost(createdPost.getId());
        userController.deleteUser(user.getId());
    }
}
