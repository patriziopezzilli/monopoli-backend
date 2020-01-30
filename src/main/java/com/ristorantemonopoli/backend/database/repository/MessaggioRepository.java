package com.ristorantemonopoli.backend.database.repository;

import com.ristorantemonopoli.backend.database.entity.Messaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessaggioRepository extends JpaRepository<Messaggio, Long> {

}

