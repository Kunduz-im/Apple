package org.example.gorest.controller;

import org.example.gorest.HttpRequest;
import org.example.gorest.endPoint.EndPoint;
import org.example.gorest.models.Post;


public class PostController extends HttpRequest {

    public PostController(String url) {
        super(url);
    }

    public Post[] getAllPosts(){
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.POSTS)).as(Post[].class);
    }

    public Post [] getPostsByUser(int userId){
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS, String.valueOf(userId), EndPoint.POSTS))
                .as(Post[].class);
    }

    public Post createPost(Post post){
        return super.post(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.POSTS), post.toJSON()).as(Post.class);
    }

    public Post updatePostPut (int postId, Post post){
        return super.put(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.POSTS, String.valueOf(postId)), post.toJSON())
                .as(Post.class);
    }

    public Post updatePostPatch (int postId, Post post){
        return super.put(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.POSTS, String.valueOf(postId)), post.toJSON())
                .as(Post.class);
    }

    public void deletePost(int postId){
        super.delete(getEndPoint(EndPoint.PUBLIC,EndPoint.V2, EndPoint.POSTS, String.valueOf(postId)));
    }
}
