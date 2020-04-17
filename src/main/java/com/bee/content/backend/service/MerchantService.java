package com.bee.content.backend.service;

import com.bee.content.backend.database.entity.MerchantEntity;

public interface MerchantService {

    MerchantEntity retrieveMerchant(String merchantCode);
}
