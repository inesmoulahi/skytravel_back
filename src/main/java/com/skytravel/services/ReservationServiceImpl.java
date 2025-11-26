package com.skytravel.services;

import com.skytravel.entities.Reservation;
import com.skytravel.entities.Passager;
import com.skytravel.entities.Vol;
import com.skytravel.repositories.ReservationRepository;
import com.skytravel.repositories.PassagerRepository;
import com.skytravel.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PassagerRepository passagerRepository;

    @Autowired
    private VolRepository volRepository;

    @Override
    public Reservation ajouterReservation(Reservation reservation) {
       
        Long idPassager = reservation.getPassager() != null ? reservation.getPassager().getIdPassager() : null;
        Long idVol = reservation.getVol() != null ? reservation.getVol().getIdVol() : null;

        if (idPassager == null || idVol == null) {
            throw new RuntimeException("Le passager ou le vol n'ont pas été spécifiés.");
        }

       
        Passager passager = passagerRepository.findById(idPassager)
                .orElseThrow(() -> new RuntimeException("Passager introuvable (ID: " + idPassager + ")"));
        Vol vol = volRepository.findById(idVol)
                .orElseThrow(() -> new RuntimeException("Vol introuvable (ID: " + idVol + ")"));

       
        reservation.setPassager(passager);
        reservation.setVol(vol);
        reservation.setDateReservation(new Date());

     
        Reservation savedReservation = reservationRepository.save(reservation);

        
        savedReservation.setPassager(passager);
        savedReservation.setVol(vol);
        return savedReservation;
    }

    @Override
    public List<Reservation> afficherToutesLesReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> trouverReservationParId(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation modifierReservation(Long id, Reservation reservation) {
        Reservation existante = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable"));

        Long idPassager = reservation.getPassager() != null ? reservation.getPassager().getIdPassager() : null;
        Long idVol = reservation.getVol() != null ? reservation.getVol().getIdVol() : null;

        if (idPassager != null) {
            Passager passager = passagerRepository.findById(idPassager)
                    .orElseThrow(() -> new RuntimeException("Passager introuvable"));
            existante.setPassager(passager);
        }

        if (idVol != null) {
            Vol vol = volRepository.findById(idVol)
                    .orElseThrow(() -> new RuntimeException("Vol introuvable"));
            existante.setVol(vol);
        }

        existante.setStatut(reservation.getStatut());
        return reservationRepository.save(existante);
    }

    @Override
    public void supprimerReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
