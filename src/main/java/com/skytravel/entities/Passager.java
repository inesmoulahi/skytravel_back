package com.skytravel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity                     // 🔹 Indique que cette classe correspond à une table dans MySQL
@Table(name = "passagers")  // 🔹 Nom de la table dans la base de données
@Data                       // 🔹 Génère automatiquement les getters, setters, toString, equals, hashCode
@AllArgsConstructor          // 🔹 Génère un constructeur avec tous les attributs
@NoArgsConstructor           // 🔹 Génère un constructeur vide
public class Passager {

    @Id                      // 🔹 Indique la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 🔹 Auto-incrémentation (comme MySQL AUTO_INCREMENT)
    private Long idPassager;

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String numeroPasseport;
    private String email;
    private String motDePasse;
}
