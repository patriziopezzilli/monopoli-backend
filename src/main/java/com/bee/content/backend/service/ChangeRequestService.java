package com.bee.content.backend.service;

import com.bee.content.backend.dto.ChangeRequestDTO;

public interface ChangeRequestService {

    ChangeRequestDTO findTemplateChangeRequest(String merchant);

    ChangeRequestDTO findPlanChangeRequest(String merchant);

    void submitChangeRequest(ChangeRequestDTO request);
}
