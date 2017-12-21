package com.solncev.repository;

import com.solncev.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Марат on 20.05.2017.
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> getAllByClientId(long clientId);
}
