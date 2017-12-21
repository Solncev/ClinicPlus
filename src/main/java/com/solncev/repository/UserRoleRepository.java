package com.solncev.repository;

import com.solncev.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Марат on 20.05.2017.
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllStatusIdByUserId(long id);
}
