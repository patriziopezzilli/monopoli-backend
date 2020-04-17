package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.MenuDelGiorno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyMenuRepository extends JpaRepository<MenuDelGiorno, Long> {

    List<MenuDelGiorno> findByCategoriaAndMerchant(String categoria, String merchant);

    void deleteAllByMerchant(String merchant);
}

