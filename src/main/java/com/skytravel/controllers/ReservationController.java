package com.skytravel.controllers;

import com.skytravel.entities.Reservation;
import com.skytravel.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "http://localhost:4200") // autorise les requêtes Angular
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // ➕ Ajouter une réservation
    @PostMapping("/ajouter")
    public ResponseEntity<Reservation> ajouterReservation(@RequestBody Reservation reservation) {
        try {
            Reservation nouvelle = reservationService.ajouterReservation(reservation);
            return ResponseEntity.ok(nouvelle);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 📜 Afficher toutes les réservations
    @GetMapping("/liste")
    public ResponseEntity<List<Reservation>> afficherToutesLesReservations() {
        List<Reservation> reservations = reservationService.afficherToutesLesReservations();
        return ResponseEntity.ok(reservations);
    }

    // 🔍 Trouver une réservation par ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> trouverReservationParId(@PathVariable Long id) {
        return reservationService.trouverReservationParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✏️ Modifier une réservation
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Reservation> modifierReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        try {
            Reservation modifiee = reservationService.modifierReservation(id, reservation);
            return ResponseEntity.ok(modifiee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ❌ Supprimer une réservation
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerReservation(@PathVariable Long id) {
        try {
            reservationService.supprimerReservation(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
