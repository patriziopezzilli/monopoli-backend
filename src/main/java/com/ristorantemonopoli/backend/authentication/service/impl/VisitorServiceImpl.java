package com.ristorantemonopoli.backend.authentication.service.impl;

import com.ristorantemonopoli.backend.authentication.service.VisitorService;
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