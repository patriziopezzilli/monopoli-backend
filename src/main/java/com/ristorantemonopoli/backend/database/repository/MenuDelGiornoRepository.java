package com.ristorantemonopoli.backend.database.repository;

import com.ristorantemonopoli.backend.database.entity.MenuDelGiorno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuDelGiornoRepository extends JpaRepository<MenuDelGiorno, Long> {

    List<MenuDelGiorno> findByCategoria(String categoria);
}

