package com.solncev.service.impl;

import com.solncev.model.Doctor;
import com.solncev.repository.DoctorRepository;
import com.solncev.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марат on 20.05.2017.
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void add(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void delete(Doctor doctor) {
        doctorRepository.delete(doctor);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getOne(Long id) {
        return doctorRepository.findOne(id);
    }

    @Override
    public List<Doctor> getLeaders() {
        List<Doctor> leaders = new ArrayList<>();
        List<Doctor> doctors = doctorRepository.findAll();
        String position = "";
        for (Doctor d : doctors) {
            position = d.getStaff().getPosition();
            if (position.startsWith("руководитель") || position.startsWith("заместитель")) {
                leaders.add(d);
            }
        }
        return leaders;
    }
}
