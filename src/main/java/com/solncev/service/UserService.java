package com.solncev.service;

import com.solncev.model.Role;
import com.solncev.model.User;

import java.util.List;

/**
 * Created by Марат on 19.04.2017.
 */
public interface UserService {

    void add(User user);

    void delete(User user);

    User getUser(String email);

    User getOne(Long id);

    boolean isAdmin(User user);

    List<Role> getRoles(User user);

    List<User> getAll();
}
