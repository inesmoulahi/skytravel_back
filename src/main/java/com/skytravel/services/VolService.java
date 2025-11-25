package com.skytravel.services;

import com.skytravel.entities.Vol;
import java.util.List;
import java.util.Optional;

public interface VolService {

    Vol ajouterVol(Vol vol);
    List<Vol> afficherTousLesVols();
    Optional<Vol> trouverVolParId(Long id);
    Vol modifierVol(Long id, Vol vol);
    void supprimerVol(Long id);
}
