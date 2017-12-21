package com.solncev.service;


import com.solncev.model.Service;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface ServiceService {

    void add(Service service);

    void delete(Service service);

    List<Service> getAll();

    Service getById(Long id);
}
