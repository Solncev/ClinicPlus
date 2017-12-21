package com.solncev.service;


import com.solncev.model.Doctor;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface DoctorService {

    void add(Doctor doctor);

    void delete(Doctor doctor);

    List<Doctor> getAll();

    Doctor getOne(Long id);

    List<Doctor> getLeaders();
}
