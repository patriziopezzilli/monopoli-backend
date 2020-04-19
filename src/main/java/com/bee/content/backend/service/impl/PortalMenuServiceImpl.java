package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.entity.PortalMenu;
import com.bee.content.backend.database.repository.MerchantRepository;
import com.bee.content.backend.database.repository.PortalMenuRepository;
import com.bee.content.backend.dto.PortalMenuDTO;
import com.bee.content.backend.service.PortalMenuService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortalMenuServiceImpl implements PortalMenuService {

    @Autowired
    private PortalMenuRepository portalMenuRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public List<PortalMenuDTO> retrievePortalMenu() {
        List<PortalMenuDTO> response = new ArrayList<>();
        List<PortalMenu> menus = portalMenuRepository.findByPlanAndParentNullOrderByPriority(
                merchantRepository.getByCode(ThreadState.INSTANCE.getMerchant()).getPlan()
        );

        if (null != menus) {
            menus.forEach(c -> {
                PortalMenuDTO dto = new PortalMenuDTO(
                        c.getTitle(),
                        c.getLink(),
                        c.getIcon());

                List<PortalMenu> menuList = portalMenuRepository.findByParentOrderByPriority(c.getId().intValue());
                if (null != menuList && !menuList.isEmpty()) {
                    dto.setChildren(new ArrayList<>());
                    menuList.forEach(t -> {
                        dto.getChildren().add(
                                new PortalMenuDTO(
                                        t.getTitle(),
                                        t.getLink(),
                                        t.getIcon())
                        );
                    });
                }
                response.add(
                        dto
                );
            });
        }

        return response;
    }
}
