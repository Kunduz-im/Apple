package org.example.gorest.controller;

import org.example.gorest.HttpRequest;
import org.example.gorest.endPoint.EndPoint;
import org.example.gorest.models.Todo;

public class ToDoController extends HttpRequest {

    public ToDoController(String url) {
        super(url);
    }

    // GET /public/v2/todos — получить все todos
    public Todo[] getAllTodos(){
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.TODOS)).as(Todo[].class);
    }

    // GET /public/v2/users/{userId}/todos — получить todos конкретного пользователя
    public Todo [] getTodosByUser(int userId){
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS, String.valueOf(userId), EndPoint.TODOS))
                .as(Todo[].class);
    }

    // POST — создать todo
    public Todo createTodo(Todo todo) {
        return super.post(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.TODOS), todo.toJSON())
                .as(Todo.class);
    }

    // PUT — полное обновление
    public Todo updateTodoPut(int toDoId, Todo todo ){
        return super.put(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.TODOS, String.valueOf(toDoId)), todo.toJSON())
                .as(Todo.class);
    }

    // PATCH — частичное обновление
    public Todo updateTodoPatch (int todoId, Todo todo){
        return super.patch(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.TODOS, String.valueOf(todoId)), todo.toJSON())
                .as(Todo.class);
    }

    // DELETE — удалить todo
    public void deleteToDo(int todoId){
         super.delete(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.TODOS, String.valueOf(todoId)));
    }
}
