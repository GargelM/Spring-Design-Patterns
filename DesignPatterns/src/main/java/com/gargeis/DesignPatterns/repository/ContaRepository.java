package com.gargeis.DesignPatterns.repository;

import com.gargeis.DesignPatterns.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {}
