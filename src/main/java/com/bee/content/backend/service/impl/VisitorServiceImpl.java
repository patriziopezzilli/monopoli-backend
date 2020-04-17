package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.repository.VisiteRepository;
import com.bee.content.backend.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisiteRepository repository;

    @Override
    public Integer countVisitors(String merchant) {
        return (int) repository.countByMerchant(merchant);
    }
}