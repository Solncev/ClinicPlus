package com.solncev.service;


import com.solncev.model.Comment;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface CommentService {

    void add(Comment comment);

    void delete(Comment comment);

    List<Comment> getAll();
}
