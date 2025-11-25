package com.skytravel.controllers;

import com.skytravel.entities.Embarquement;
import com.skytravel.services.EmbarquementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/embarquements")
@CrossOrigin(origins = "http://localhost:4200")
public class EmbarquementController {

    @Autowired
    private EmbarquementService embarquementService;

    @PostMapping("/ajouter")
    public ResponseEntity<Embarquement> ajouterEmbarquement(@RequestBody Embarquement embarquement) {
        return ResponseEntity.ok(embarquementService.ajouterEmbarquement(embarquement));
    }

    @GetMapping("/liste")
    public ResponseEntity<List<Embarquement>> afficherTousLesEmbarquements() {
        return ResponseEntity.ok(embarquementService.afficherTousLesEmbarquements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Embarquement> trouverEmbarquementParId(@PathVariable Long id) {
        return embarquementService.trouverEmbarquementParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Embarquement> modifierEmbarquement(@PathVariable Long id, @RequestBody Embarquement embarquement) {
        return ResponseEntity.ok(embarquementService.modifierEmbarquement(id, embarquement));
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerEmbarquement(@PathVariable Long id) {
        embarquementService.supprimerEmbarquement(id);
        return ResponseEntity.noContent().build();
    }
}
