package com.skytravel.services;

import com.skytravel.entities.Passager;
import com.skytravel.repositories.PassagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  // 🔹 Indique à Spring Boot que cette classe contient la logique métier
public class PassagerServiceImpl implements PassagerService {

    @Autowired
    private PassagerRepository passagerRepository; // 🔹 Injection du repository

    @Override
    public Passager ajouterPassager(Passager passager) {
        return passagerRepository.save(passager);
    }

    @Override
    public List<Passager> afficherTousLesPassagers() {
        return passagerRepository.findAll();
    }

    @Override
    public Optional<Passager> trouverParId(Long id) {
        return passagerRepository.findById(id);
    }

    @Override
    public Passager modifierPassager(Long id, Passager passager) {
        Passager existant = passagerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passager introuvable"));
        existant.setNom(passager.getNom());
        existant.setPrenom(passager.getPrenom());
        existant.setEmail(passager.getEmail());
        existant.setMotDePasse(passager.getMotDePasse());
        existant.setDateNaissance(passager.getDateNaissance());
        existant.setNumeroPasseport(passager.getNumeroPasseport());
        return passagerRepository.save(existant);
    }

    @Override
    public void supprimerPassager(Long id) {
        passagerRepository.deleteById(id);
    }
}
