package com.gargeis.DesignPatterns.repository;

import com.gargeis.DesignPatterns.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}