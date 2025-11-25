package com.skytravel.services;

import com.skytravel.entities.Reservation;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Reservation ajouterReservation(Reservation reservation);
    List<Reservation> afficherToutesLesReservations();
    Optional<Reservation> trouverReservationParId(Long id);
    Reservation modifierReservation(Long id, Reservation reservation);
    void supprimerReservation(Long id);
}
