package com.solncev.service;

import com.solncev.model.News;

import java.util.List;

/**
 * Created by Марат on 19.04.2017.
 */
public interface NewsService {

    void add(News news);

    void delete(News news);

    List<News> getAll();

    News getOne(Long id);
}
