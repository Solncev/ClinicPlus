package com.solncev.service;


import com.solncev.model.UserRole;

import java.util.List;

/**
 * Created by Марат on 07.11.2016.
 */
public interface UserRoleService {

    void add(UserRole userRole);

    void delete(UserRole userRole);

    List<UserRole> getAll();
}
