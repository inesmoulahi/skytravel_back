package com.skytravel.services;

import com.skytravel.entities.Passager;
import java.util.List;
import java.util.Optional;

public interface PassagerService {

    Passager ajouterPassager(Passager passager);
    List<Passager> afficherTousLesPassagers();
    Optional<Passager> trouverParId(Long id);
    Passager modifierPassager(Long id, Passager passager);
    void supprimerPassager(Long id);
}
