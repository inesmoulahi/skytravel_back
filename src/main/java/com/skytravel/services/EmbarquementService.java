package com.skytravel.services;

import com.skytravel.entities.Embarquement;
import java.util.List;
import java.util.Optional;

public interface EmbarquementService {
    Embarquement ajouterEmbarquement(Embarquement embarquement);
    List<Embarquement> afficherTousLesEmbarquements();
    Optional<Embarquement> trouverEmbarquementParId(Long id);
    Embarquement modifierEmbarquement(Long id, Embarquement embarquement);
    void supprimerEmbarquement(Long id);
}
