package com.bee.content.backend.service;

import com.bee.content.backend.dto.PortalMenuDTO;

import java.util.List;

public interface PortalMenuService {

    List<PortalMenuDTO> retrievePortalMenu();
}
