package org.example.gorest.controller;

import org.example.gorest.HttpRequest;
import org.example.gorest.endPoint.EndPoint;
import org.example.gorest.models.Comment;


public class CommentController extends HttpRequest {

    public CommentController(String url) {
        super(url);
    }


//    deleteComment

    public Comment[] getAllComments(){
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.COMMENTS)).as(Comment[].class);
    }

    public Comment [] getCommentsByPost (int postId){
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.POSTS, String.valueOf(postId), EndPoint.COMMENTS))
                .as(Comment[].class);
    }

    public Comment createComment(Comment comment){
        return super.post(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.COMMENTS), comment.toJSON())
                .as(Comment.class);
    }

    public Comment updateCommentPut(int commentId, Comment comment){
        return super.put(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.COMMENTS, String.valueOf(commentId)), comment.toJSON())
                .as(Comment.class);
    }

    public Comment updateCommentPatch(int commentId, Comment comment){
        return super.put(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.COMMENTS, String.valueOf(commentId)), comment.toJSON())
                .as(Comment.class);
    }

    public void deleteComment(int commentId){
        super.delete(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.COMMENTS, String.valueOf(commentId)));
    }
}
