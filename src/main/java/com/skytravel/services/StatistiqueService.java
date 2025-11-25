package com.skytravel.services;

import com.skytravel.entities.Statistique;
import com.skytravel.repositories.BilletRepository;
import com.skytravel.repositories.PassagerRepository;
import com.skytravel.repositories.ReservationRepository;
import com.skytravel.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatistiqueService {

    @Autowired
    private PassagerRepository passagerRepository;

    @Autowired
    private VolRepository volRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private BilletRepository billetRepository;

    public Statistique genererStatistiques() {
        int totalPassagers = (int) passagerRepository.count();
        int totalVols = (int) volRepository.count();
        int totalReservations = (int) reservationRepository.count();

        double revenuTotal = billetRepository.findAll().stream()
                .mapToDouble(b -> b.getPrixTotal())
                .sum();

        return new Statistique(totalPassagers, totalVols, totalReservations, revenuTotal);
    }
}
