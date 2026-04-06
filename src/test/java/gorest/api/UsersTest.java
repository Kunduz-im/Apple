package gorest.api;

import org.example.gorest.controller.UserController;
import org.example.gorest.generator.UserGenerator;
import org.example.gorest.models.User;
import org.example.gorest.utils.ConfigurationManager;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("API")
public class UsersTest {

    // Создаём контроллер — он знает базовый URL и токен
    UserController userController = new UserController(ConfigurationManager.getBadeConfig().gorestBaseUrl());


    @Test
    void getAllUsersTest() {
        userController.getAllUsers();
    }

    @Test
    void fullUserCrudTest() {

        // CREATE — создаём пользователя со случайными данными
        User newUser = UserGenerator.randomUser();
        User createdUser = userController.createNewUser(newUser);

        assertThat(userController.getResponse().getStatusCode())
                .as("Actual and expected status code are mismatch " )
                        .isEqualTo(201);

        assertThat(createdUser)
                .as("Response body mismatch ")
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(newUser);

        assertThat(userController.getResponse().getTime())
                .as("More than 1 minute")
                .isLessThan(10000L);

        assertThat(userController.getResponse().getHeader("x-frame-options"))
                .as("is not SAMEORIGIN")
                        .isEqualTo("SAMEORIGIN");

        assertThat(userController.getResponse().asByteArray().length)
                .as("Response size mismatch")
                        .isNotEqualTo(null);

        assertThat(createdUser.getId()).as("ID is Null")
                .isNotEqualTo(null);

        // PUT — полное обновление (нужно передать ВСЕ поля)
        createdUser.setName("UpdatedName");
        createdUser.setStatus("Inactive");
        userController.updateUserPut(createdUser.getId(), createdUser);


        // PATCH — частичное обновление (только то что меняем)
        // Благодаря @JsonInclude(NON_NULL) отправится только {"name":"PatchedName"}
        User patchData = User.builder().name("PatchedName").build();
        userController.updateUserPatch(createdUser.getId(), patchData);


        // DELETE — удаляем пользователя
        userController.deleteUser(createdUser.getId());

    }
}
