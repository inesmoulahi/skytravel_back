package com.skytravel.services;

import com.skytravel.entities.Vol;
import com.skytravel.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VolServiceImpl implements VolService {

    @Autowired
    private VolRepository volRepository;

    @Override
    public Vol ajouterVol(Vol vol) {
        return volRepository.save(vol);
    }

    @Override
    public List<Vol> afficherTousLesVols() {
        return volRepository.findAll();
    }

    @Override
    public Optional<Vol> trouverVolParId(Long id) {
        return volRepository.findById(id);
    }

    @Override
    public Vol modifierVol(Long id, Vol vol) {
        Vol existant = volRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vol introuvable"));
        existant.setCompagnie(vol.getCompagnie());
        existant.setNumeroVol(vol.getNumeroVol());
        existant.setVilleDepart(vol.getVilleDepart());
        existant.setVilleArrivee(vol.getVilleArrivee());
        existant.setDateDepart(vol.getDateDepart());
        existant.setDateArrivee(vol.getDateArrivee());
        existant.setPrix(vol.getPrix());
        return volRepository.save(existant);
    }

    @Override
    public void supprimerVol(Long id) {
        volRepository.deleteById(id);
    }
}
