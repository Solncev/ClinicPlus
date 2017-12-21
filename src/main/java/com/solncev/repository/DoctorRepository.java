package com.solncev.repository;

import com.solncev.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Марат on 20.05.2017.
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
