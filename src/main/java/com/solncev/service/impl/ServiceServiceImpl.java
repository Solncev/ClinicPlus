package com.solncev.service.impl;

import com.solncev.model.Service;
import com.solncev.repository.ServiceRepository;
import com.solncev.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Марат on 20.05.2017.
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void add(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(Service service) {
        serviceRepository.delete(service);
    }

    @Override
    public List<Service> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service getById(Long id) {
        return serviceRepository.findOne(id);
    }
}
