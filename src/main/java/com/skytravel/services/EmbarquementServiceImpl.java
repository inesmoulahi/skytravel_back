package com.skytravel.services;

import com.skytravel.entities.Billet;
import com.skytravel.entities.Embarquement;
import com.skytravel.repositories.BilletRepository;
import com.skytravel.repositories.EmbarquementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmbarquementServiceImpl implements EmbarquementService {

    @Autowired
    private EmbarquementRepository embarquementRepository;

    @Autowired
    private BilletRepository billetRepository;

    @Override
    public Embarquement ajouterEmbarquement(Embarquement embarquement) {
        // Vérifie que le billet existe avant de créer l’embarquement
        if (embarquement.getBillet() != null && embarquement.getBillet().getIdBillet() != null) {
            Billet billet = billetRepository.findById(embarquement.getBillet().getIdBillet())
                    .orElseThrow(() -> new RuntimeException("Billet introuvable"));
            embarquement.setBillet(billet);
        }

        // Définit automatiquement la date actuelle si vide
        if (embarquement.getHeureEmbarquement() == null) {
            embarquement.setHeureEmbarquement(new Date());
        }

        return embarquementRepository.save(embarquement);
    }

    @Override
    public List<Embarquement> afficherTousLesEmbarquements() {
        return embarquementRepository.findAll();
    }

    @Override
    public Optional<Embarquement> trouverEmbarquementParId(Long id) {
        return embarquementRepository.findById(id);
    }

    @Override
    public Embarquement modifierEmbarquement(Long id, Embarquement embarquement) {
        Embarquement existant = embarquementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Embarquement introuvable"));

        existant.setPorte(embarquement.getPorte());
        existant.setZone(embarquement.getZone());
        existant.setHeureEmbarquement(embarquement.getHeureEmbarquement());

        if (embarquement.getBillet() != null && embarquement.getBillet().getIdBillet() != null) {
            Billet billet = billetRepository.findById(embarquement.getBillet().getIdBillet())
                    .orElseThrow(() -> new RuntimeException("Billet introuvable"));
            existant.setBillet(billet);
        }

        return embarquementRepository.save(existant);
    }

    @Override
    public void supprimerEmbarquement(Long id) {
        embarquementRepository.deleteById(id);
    }
}
