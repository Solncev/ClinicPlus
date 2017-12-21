package com.solncev.repository;

import com.solncev.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Марат on 20.05.2017.
 */
public interface DealRepository extends JpaRepository<Deal, Long> {
}
