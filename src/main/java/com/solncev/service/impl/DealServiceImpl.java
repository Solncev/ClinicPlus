package com.solncev.service.impl;

import com.solncev.model.Deal;
import com.solncev.repository.DealRepository;
import com.solncev.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Марат on 20.05.2017.
 */
@Service
public class DealServiceImpl implements DealService {
    private final DealRepository dealRepository;

    @Autowired
    public DealServiceImpl(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    @Override
    public void add(Deal deal) {
        dealRepository.save(deal);
    }

    @Override
    public void delete(Deal deal) {
        dealRepository.delete(deal);
    }

    @Override
    public List<Deal> getAll() {
        return dealRepository.findAll();
    }
}
