package com.solncev.service;


import com.solncev.model.Appointment;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface AppointmentService {

    void delete(Appointment appointment);

    void add(Appointment appointment);

    List<Appointment> getAllByClientId(long clientId);

    List<Appointment> getAll();
}
