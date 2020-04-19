package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.Plan;
import com.bee.content.backend.database.entity.PortalMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortalMenuRepository extends JpaRepository<PortalMenu, Long>{

    List<PortalMenu> findByPlanAndParentNullOrderByPriority(String plan);

    List<PortalMenu> findByParentOrderByPriority(Integer parent);

}

