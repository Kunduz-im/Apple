package org.example.gorest.controller;


import org.example.gorest.HttpRequest;
import org.example.gorest.endPoint.EndPoint;
import org.example.gorest.models.User;

public class UserController extends HttpRequest {

    public UserController(String url) {
        super(url);
    }

    public User[] getAllUsers (){
       return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS)).as(User[].class);
    }

    public User createNewUser(User user ){
        return super.post(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS), user.toJSON()).as(User.class);
    }

    public User updateUserPut(int userId, User user){
        return super.put(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS, String.valueOf(userId)), user.toJSON())
                .as(User.class);
    }

    public User updateUserPatch(int userID, User user){
        return super.patch(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS, String.valueOf(userID)), user.toJSON())
                .as(User.class);
    }

    public void deleteUser(int userId){
        super.delete(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS, String.valueOf(userId)));
    }


}
