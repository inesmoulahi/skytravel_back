package com.skytravel.services;

import com.skytravel.entities.Utilisateur;
import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
    List<Utilisateur> afficherTousLesUtilisateurs();
    Optional<Utilisateur> trouverUtilisateurParId(Long id);
    Utilisateur modifierUtilisateur(Long id, Utilisateur utilisateur);
    void supprimerUtilisateur(Long id);
}
