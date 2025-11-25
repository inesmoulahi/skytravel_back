package com.skytravel.services;

import com.skytravel.entities.Billet;
import java.util.List;
import java.util.Optional;

public interface BilletService {

    Billet ajouterBillet(Billet billet);
    List<Billet> afficherTousLesBillets();
    Optional<Billet> trouverBilletParId(Long id);
    Billet modifierBillet(Long id, Billet billet);
    void supprimerBillet(Long id);
}
