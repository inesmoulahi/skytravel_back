package com.skytravel.services;

import com.skytravel.entities.Billet;
import com.skytravel.entities.Reservation;
import com.skytravel.repositories.BilletRepository;
import com.skytravel.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BilletServiceImpl implements BilletService {

    @Autowired
    private BilletRepository billetRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Billet ajouterBillet(Billet billet) {
        // 🔹 On vérifie si une réservation existe bien avec l'ID fourni
        if (billet.getReservation() != null && billet.getReservation().getIdReservation() != null) {
            Reservation reservation = reservationRepository.findById(billet.getReservation().getIdReservation())
                    .orElseThrow(() -> new RuntimeException("Réservation introuvable"));
            billet.setReservation(reservation); // lie la réservation complète
        }

        // 🔹 Ajout des autres informations automatiques
        billet.setDateEmission(new Date());
        billet.setNumeroBillet(UUID.randomUUID().toString()); // numéro unique automatique

        return billetRepository.save(billet);
    }

    @Override
    public List<Billet> afficherTousLesBillets() {
        return billetRepository.findAll();
    }

    @Override
    public Optional<Billet> trouverBilletParId(Long id) {
        return billetRepository.findById(id);
    }

    @Override
    public Billet modifierBillet(Long id, Billet billet) {
        Billet existant = billetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Billet introuvable"));

        existant.setPrixTotal(billet.getPrixTotal());

        // 🔹 Mettre à jour la réservation liée si nécessaire
        if (billet.getReservation() != null && billet.getReservation().getIdReservation() != null) {
            Reservation reservation = reservationRepository.findById(billet.getReservation().getIdReservation())
                    .orElseThrow(() -> new RuntimeException("Réservation introuvable"));
            existant.setReservation(reservation);
        }

        return billetRepository.save(existant);
    }

    @Override
    public void supprimerBillet(Long id) {
        billetRepository.deleteById(id);
    }
}
