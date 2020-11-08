package com.gargeis.DesignPatterns.repository;

import com.gargeis.DesignPatterns.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {}
