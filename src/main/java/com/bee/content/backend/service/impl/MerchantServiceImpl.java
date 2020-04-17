package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.entity.MerchantEntity;
import com.bee.content.backend.database.repository.MerchantRepository;
import com.bee.content.backend.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository repository;

    @Override
    public MerchantEntity retrieveMerchant(String merchantCode) {
        return repository.getByCode(merchantCode);
    }
}
