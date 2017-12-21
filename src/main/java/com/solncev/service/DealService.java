package com.solncev.service;


import com.solncev.model.Deal;

import java.util.List;

/**
 * Created by Марат on 27.10.2016.
 */
public interface DealService {

    void add(Deal deal);

    void delete(Deal deal);

    List<Deal> getAll();
}
