package com.solncev.service;


import com.solncev.model.Staff;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface StaffService {

    void add(Staff staff);

    void delete(Staff staff);

    List<Staff> getAll();
}
