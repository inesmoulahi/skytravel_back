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
public class Vol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVol;

    private String compagnie;
    private String numeroVol;
    private String villeDepart;
    private String villeArrivee;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDepart;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateArrivee;

    private Double prix;
}
