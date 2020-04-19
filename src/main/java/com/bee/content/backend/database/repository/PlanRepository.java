package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.Plan;
import com.bee.content.backend.database.entity.Visite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long>{

}

