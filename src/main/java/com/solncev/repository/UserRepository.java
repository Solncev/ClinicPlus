package com.solncev.repository;

import com.solncev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Марат on 19.04.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByLogin(String login);
}