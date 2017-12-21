package com.solncev.service.impl;

import com.solncev.model.Appointment;
import com.solncev.repository.AppointmentRepository;
import com.solncev.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Марат on 20.05.2017.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void delete(Appointment appointment) {
        appointmentRepository.delete(appointment);
    }

    @Override
    public void add(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllByClientId(long clientId) {
        return appointmentRepository.getAllByClientId(clientId);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }
}
