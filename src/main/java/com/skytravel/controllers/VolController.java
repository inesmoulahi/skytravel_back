package com.skytravel.controllers;

import com.skytravel.entities.Vol;
import com.skytravel.services.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vols")
@CrossOrigin(origins = "http://localhost:4200")
public class VolController {

    @Autowired
    private VolService volService;

    @PostMapping("/ajouter")
    public ResponseEntity<Vol> ajouterVol(@RequestBody Vol vol) {
        Vol nouveau = volService.ajouterVol(vol);
        return ResponseEntity.ok(nouveau);
    }

    @GetMapping("/liste")
    public ResponseEntity<List<Vol>> afficherTousLesVols() {
        return ResponseEntity.ok(volService.afficherTousLesVols());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vol> trouverVolParId(@PathVariable Long id) {
        return volService.trouverVolParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Vol> modifierVol(@PathVariable Long id, @RequestBody Vol vol) {
        return ResponseEntity.ok(volService.modifierVol(id, vol));
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerVol(@PathVariable Long id) {
        volService.supprimerVol(id);
        return ResponseEntity.noContent().build();
    }
}
