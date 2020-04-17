package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByCategoriaAndMerchant(String categoria, String merchant);

    void deleteByIdAndMerchant(Long id, String merchant);
}

