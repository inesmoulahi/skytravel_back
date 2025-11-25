package com.skytravel.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Embarquement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmbarquement;

    private String porte;
    private String zone;  

    @Temporal(TemporalType.TIMESTAMP)
    private Date heureEmbarquement;

    @OneToOne
    @JoinColumn(name = "id_billet", nullable = false)
    private Billet billet;

    // 🔹 Constructeurs
    public Embarquement() {}

    public Embarquement(String porte, String zone, Date heureEmbarquement, Billet billet) {
        this.porte = porte;
        this.zone = zone;
        this.heureEmbarquement = heureEmbarquement;
        this.billet = billet;
    }

   
    public Long getIdEmbarquement() {
        return idEmbarquement;
    }

    public void setIdEmbarquement(Long idEmbarquement) {
        this.idEmbarquement = idEmbarquement;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Date getHeureEmbarquement() {
        return heureEmbarquement;
    }

    public void setHeureEmbarquement(Date heureEmbarquement) {
        this.heureEmbarquement = heureEmbarquement;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }
}
