package com.skytravel.repositories;

import com.skytravel.entities.Embarquement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmbarquementRepository extends JpaRepository<Embarquement, Long> {
}
