package gorest.api;

import org.example.gorest.controller.ToDoController;
import org.example.gorest.controller.UserController;
import org.example.gorest.generator.TodoGenerator;
import org.example.gorest.generator.UserGenerator;
import org.example.gorest.models.Todo;
import org.example.gorest.models.User;
import org.example.gorest.utils.ConfigurationManager;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("API")
public class TodoTest {

    // Создаём контроллер — он знает базовый URL и токен
    UserController userController = new UserController(ConfigurationManager.getBadeConfig().gorestBaseUrl());
    ToDoController toDoController = new ToDoController(ConfigurationManager.getBadeConfig().gorestBaseUrl());

    @Test
    void getAllTodosTest() {
        toDoController.getAllTodos();
    }

    @Test
    void fullTodoCrudTest(){
        //Todo привязан к пользователю — сначала создаём юзера
        User user = userController.createNewUser(UserGenerator.randomUser());

        // CREATE todo
        Todo newTodo = TodoGenerator.randomTodo(user.getId());
        Todo createdTodo = toDoController.createTodo(newTodo);

        // PUT — полное обновление todo
        createdTodo.setTitle("Updated Todo Title");
        createdTodo.setStatus("completed");
        toDoController.updateTodoPut(createdTodo.getId(), createdTodo);


        // PATCH — меняем только статус
        Todo patchData = Todo.builder().status("pending").build();
        toDoController.updateTodoPatch(createdTodo.getId(), patchData);


        // DELETE
        toDoController.deleteToDo(createdTodo.getId());


        // Чистим за собой — удаляем пользователя
        userController.deleteUser(user.getId());
    }
}
