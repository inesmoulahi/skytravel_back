package com.skytravel.controllers;

import com.skytravel.entities.Billet;
import com.skytravel.services.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/billets")
@CrossOrigin(origins = "http://localhost:4200")
public class BilletController {

    @Autowired
    private BilletService billetService;

    @PostMapping("/ajouter")
    public ResponseEntity<Billet> ajouterBillet(@RequestBody Billet billet) {
        Billet nouveau = billetService.ajouterBillet(billet);
        return ResponseEntity.ok(nouveau);
    }

    @GetMapping("/liste")
    public ResponseEntity<List<Billet>> afficherTousLesBillets() {
        return ResponseEntity.ok(billetService.afficherTousLesBillets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billet> trouverBilletParId(@PathVariable Long id) {
        return billetService.trouverBilletParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Billet> modifierBillet(@PathVariable Long id, @RequestBody Billet billet) {
        return ResponseEntity.ok(billetService.modifierBillet(id, billet));
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerBillet(@PathVariable Long id) {
        billetService.supprimerBillet(id);
        return ResponseEntity.noContent().build();
    }
}
