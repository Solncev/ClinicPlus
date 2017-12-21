package com.solncev.service;

import com.solncev.model.Question;

import java.util.List;

/**
 * Created by Марат on 20.05.2017.
 */
public interface QuestionService {

    void add(Question question);

    void delete(Question question);

    List<Question> getAll();
}
