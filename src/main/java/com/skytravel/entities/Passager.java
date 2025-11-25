package com.skytravel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity                     
@Table(name = "passagers")  
@Data                       
@AllArgsConstructor          
@NoArgsConstructor           
public class Passager {

    @Id                     
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idPassager;

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String numeroPasseport;
    private String email;
    private String motDePasse;
}
