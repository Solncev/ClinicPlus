package com.solncev.service.impl;

import com.solncev.model.Role;
import com.solncev.model.User;
import com.solncev.model.UserRole;
import com.solncev.repository.UserRepository;
import com.solncev.repository.UserRoleRepository;
import com.solncev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 19.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public User getUser(String email) {
        return userRepository.getUserByLogin(email);
    }

    @Override
    public User getOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public boolean isAdmin(User user) {
        List<Role> roles = getRoles(user);
        for (Role role : roles) {
            if (role.getName().equals("ADMIN")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Role> getRoles(User user) {
        List<Role> roles = new ArrayList<>();
        List<UserRole> userRoles = userRoleRepository.findAllStatusIdByUserId(user.getId());
        for (UserRole userRole : userRoles) {
            roles.add(userRole.getRole());
        }
        return roles;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
