package com.bee.content.backend.service;

import com.bee.content.backend.dto.MenuDelGiornoSaveRequest;
import com.bee.content.backend.dto.PastoDTO;

import java.util.List;

public interface DailyMenuService {

    List<PastoDTO> retrievePlates(String categoria, String merchant);

    void saveDailyMenu(MenuDelGiornoSaveRequest request, String merchant);

    void sendToPrint(String merchant);

    void notifyCustomers(String merchant);
}
