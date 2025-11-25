package com.skytravel.controllers;

import com.skytravel.entities.Utilisateur;
import com.skytravel.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // ✅ Ajouter un utilisateur
    @PostMapping("/ajouter")
    public ResponseEntity<Utilisateur> ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        return ResponseEntity.ok(utilisateurService.ajouterUtilisateur(utilisateur));
    }

    // ✅ Afficher tous les utilisateurs
    @GetMapping("/liste")
    public ResponseEntity<List<Utilisateur>> afficherTousLesUtilisateurs() {
        return ResponseEntity.ok(utilisateurService.afficherTousLesUtilisateurs());
    }

    // ✅ Trouver un utilisateur par ID
    @GetMapping("/trouver/{id}")
    public ResponseEntity<Utilisateur> trouverUtilisateurParId(@PathVariable Long id) {
        return utilisateurService.trouverUtilisateurParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Modifier un utilisateur
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Utilisateur> modifierUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        return ResponseEntity.ok(utilisateurService.modifierUtilisateur(id, utilisateur));
    }

    // ✅ Supprimer un utilisateur
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerUtilisateur(@PathVariable Long id) {
        utilisateurService.supprimerUtilisateur(id);
        return ResponseEntity.noContent().build();
    }
}
