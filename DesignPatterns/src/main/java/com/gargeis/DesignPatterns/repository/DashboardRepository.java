package com.gargeis.DesignPatterns.repository;

import com.gargeis.DesignPatterns.model.DadosDashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<DadosDashboard, Integer> {
}
