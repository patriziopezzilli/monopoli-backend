package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.entity.ChangeRequest;
import com.bee.content.backend.database.repository.ChangeRequestRepository;
import com.bee.content.backend.dto.ChangeRequestDTO;
import com.bee.content.backend.service.ChangeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeRequestServiceImpl implements ChangeRequestService {
    private static final String TEMPLATE_TYPE = "template";
    private static final String PLAN_TYPE = "plan";

    @Autowired
    private ChangeRequestRepository changeRequestRepository;

    @Override
    public ChangeRequestDTO findTemplateChangeRequest(String merchant) {
        ChangeRequest request = changeRequestRepository.findByTypeAndMerchantAndCompleted(
                TEMPLATE_TYPE,
                merchant,
                false
        );

        if (null != request) {
            return new ChangeRequestDTO(
                    request.getType(),
                    request.getPrevious(),
                    request.getNext(),
                    request.getCompleted(),
                    request.getMerchant()
            );
        }

        return null;
    }

    @Override
    public ChangeRequestDTO findPlanChangeRequest(String merchant) {
        ChangeRequest request = changeRequestRepository.findByTypeAndMerchantAndCompleted(
                PLAN_TYPE,
                merchant,
                false
        );

        if (null != request) {
            return new ChangeRequestDTO(
                    request.getType(),
                    request.getPrevious(),
                    request.getNext(),
                    request.getCompleted(),
                    request.getMerchant()
            );
        }

        return null;
    }

    @Override
    public void submitChangeRequest(ChangeRequestDTO request) {
        ChangeRequest entity = new ChangeRequest();
        entity.setCompleted(false);
        entity.setMerchant(request.getMerchant());
        entity.setType(request.getType());
        entity.setPrevious(request.getPrevious());
        entity.setNext(request.getNext());

        changeRequestRepository.save(entity);
    }
}
