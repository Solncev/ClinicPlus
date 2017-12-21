package com.solncev.repository;

import com.solncev.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Марат on 19.04.2017.
 */
public interface NewsRepository extends JpaRepository<News, Long> {
}
