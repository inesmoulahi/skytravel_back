package com.skytravel.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBillet;

    private String numeroBillet;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEmission;

    private double prixTotal;

    @ManyToOne
    @JoinColumn(name = "id_reservation", nullable = false)
    private Reservation reservation;

    // 🔹 Constructeurs
    public Billet() {
    }

    public Billet(String numeroBillet, Date dateEmission, double prixTotal, Reservation reservation) {
        this.numeroBillet = numeroBillet;
        this.dateEmission = dateEmission;
        this.prixTotal = prixTotal;
        this.reservation = reservation;
    }

    // 🔹 Getters et Setters
    public Long getIdBillet() {
        return idBillet;
    }

    public void setIdBillet(Long idBillet) {
        this.idBillet = idBillet;
    }

    public String getNumeroBillet() {
        return numeroBillet;
    }

    public void setNumeroBillet(String numeroBillet) {
        this.numeroBillet = numeroBillet;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
