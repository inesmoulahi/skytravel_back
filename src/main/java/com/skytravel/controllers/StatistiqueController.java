package com.skytravel.controllers;

import com.skytravel.entities.Statistique;
import com.skytravel.services.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/statistiques")
@CrossOrigin(origins = "http://localhost:4200")
public class StatistiqueController {

    @Autowired
    private StatistiqueService statistiqueService;

    @GetMapping("/generer")
    public Statistique genererStatistiques() {
        return statistiqueService.genererStatistiques();
    }
}
