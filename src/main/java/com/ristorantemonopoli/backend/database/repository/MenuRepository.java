package com.ristorantemonopoli.backend.database.repository;

import com.ristorantemonopoli.backend.database.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByCategoria(String categoria);
}

