package com.solncev.service;


import com.solncev.model.Role;

import java.util.List;

/**
 * Created by Марат on 07.11.2016.
 */
public interface RoleService {

    void add(Role role);

    void delete(Role role);

    List<Role> getAll();

    Role getOne(Long id);
}
