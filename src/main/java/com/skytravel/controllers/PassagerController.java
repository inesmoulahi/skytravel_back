package com.skytravel.controllers;

import com.skytravel.entities.Passager;
import com.skytravel.services.PassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // 🔹 Indique qu’il s’agit d’un contrôleur REST
@RequestMapping("/api/passagers")  // 🔹 Toutes les routes commencent par /api/passagers
@CrossOrigin(origins = "http://localhost:4200") // 🔹 Permet à Angular d’accéder au backend
public class PassagerController {

    @Autowired
    private PassagerService passagerService; // 🔹 Injection du service

    // -------------------- CREATE --------------------
    @PostMapping("/ajouter")
    public ResponseEntity<Passager> ajouterPassager(@RequestBody Passager passager) {
        Passager nouveau = passagerService.ajouterPassager(passager);
        return ResponseEntity.ok(nouveau);
    }

    // -------------------- READ ALL --------------------
    @GetMapping("/liste")
    public ResponseEntity<List<Passager>> afficherTousLesPassagers() {
        List<Passager> passagers = passagerService.afficherTousLesPassagers();
        return ResponseEntity.ok(passagers);
    }

    // -------------------- READ BY ID --------------------
    @GetMapping("/{id}")
    public ResponseEntity<Passager> trouverParId(@PathVariable Long id) {
        return passagerService.trouverParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // -------------------- UPDATE --------------------
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Passager> modifierPassager(@PathVariable Long id, @RequestBody Passager passager) {
        Passager modifie = passagerService.modifierPassager(id, passager);
        return ResponseEntity.ok(modifie);
    }

    // -------------------- DELETE --------------------
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerPassager(@PathVariable Long id) {
        passagerService.supprimerPassager(id);
        return ResponseEntity.noContent().build();
    }
}

