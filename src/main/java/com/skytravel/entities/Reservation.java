package com.skytravel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    // 🔹 Relation avec Passager (un passager peut avoir plusieurs réservations)
    @ManyToOne
    @JoinColumn(name = "id_passager")
    private Passager passager;

    // 🔹 Relation avec Vol (un vol peut avoir plusieurs réservations)
    @ManyToOne
    @JoinColumn(name = "id_vol")
    private Vol vol;

    // 🔹 Relation avec Utilisateur (un utilisateur peut avoir plusieurs réservations)
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReservation;

    private String statut; // exemple : "Confirmée", "Annulée", etc.
}
