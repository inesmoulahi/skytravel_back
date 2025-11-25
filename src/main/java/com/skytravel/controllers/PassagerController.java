package com.skytravel.controllers;

import com.skytravel.entities.Passager;
import com.skytravel.services.PassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passagers")  
@CrossOrigin(origins = "http://localhost:4200") 
public class PassagerController {

    @Autowired
    private PassagerService passagerService;

  
    @PostMapping("/ajouter")
    public ResponseEntity<Passager> ajouterPassager(@RequestBody Passager passager) {
        Passager nouveau = passagerService.ajouterPassager(passager);
        return ResponseEntity.ok(nouveau);
    }


    @GetMapping("/liste")
    public ResponseEntity<List<Passager>> afficherTousLesPassagers() {
        List<Passager> passagers = passagerService.afficherTousLesPassagers();
        return ResponseEntity.ok(passagers);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Passager> trouverParId(@PathVariable Long id) {
        return passagerService.trouverParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/modifier/{id}")
    public ResponseEntity<Passager> modifierPassager(@PathVariable Long id, @RequestBody Passager passager) {
        Passager modifie = passagerService.modifierPassager(id, passager);
        return ResponseEntity.ok(modifie);
    }

    
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerPassager(@PathVariable Long id) {
        passagerService.supprimerPassager(id);
        return ResponseEntity.noContent().build();
    }
}

