package com.ristorantemonopoli.backend.service.impl;

import com.ristorantemonopoli.backend.service.VisitorService;
import com.ristorantemonopoli.backend.database.repository.VisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisiteRepository repository;

    @Override
    public Integer countVisitors() {
        return (int) repository.count();
    }
}