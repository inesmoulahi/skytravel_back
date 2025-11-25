package com.skytravel.entities;

import jakarta.persistence.*;

@Entity
public class Statistique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatistique;

    private int totalPassagers;
    private int totalVols;
    private int totalReservations;
    private double revenuTotal;

    public Statistique() {}

    public Statistique(int totalPassagers, int totalVols, int totalReservations, double revenuTotal) {
        this.totalPassagers = totalPassagers;
        this.totalVols = totalVols;
        this.totalReservations = totalReservations;
        this.revenuTotal = revenuTotal;
    }

    public Long getIdStatistique() {
        return idStatistique;
    }

    public void setIdStatistique(Long idStatistique) {
        this.idStatistique = idStatistique;
    }

    public int getTotalPassagers() {
        return totalPassagers;
    }

    public void setTotalPassagers(int totalPassagers) {
        this.totalPassagers = totalPassagers;
    }

    public int getTotalVols() {
        return totalVols;
    }

    public void setTotalVols(int totalVols) {
        this.totalVols = totalVols;
    }

    public int getTotalReservations() {
        return totalReservations;
    }

    public void setTotalReservations(int totalReservations) {
        this.totalReservations = totalReservations;
    }

    public double getRevenuTotal() {
        return revenuTotal;
    }

    public void setRevenuTotal(double revenuTotal) {
        this.revenuTotal = revenuTotal;
    }
}
