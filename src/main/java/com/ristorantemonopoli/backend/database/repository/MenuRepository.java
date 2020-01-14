package com.ristorantemonopoli.backend.database.repository;

import com.ristorantemonopoli.backend.database.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}

