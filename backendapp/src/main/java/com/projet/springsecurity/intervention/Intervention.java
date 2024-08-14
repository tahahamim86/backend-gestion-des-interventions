package com.projet.springsecurity.intervention;


import java.util.Date;
import java.util.Set;

import com.projet.springsecurity.etapes_interventions.etapes_intervention;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description; // Renamed to avoid confusion with `desc` keyword

    @Column(nullable = false)
    private Date dateDebut;

    private Date dateFin;

    @Column(nullable = false)
    private String etat;

    @OneToMany(mappedBy = "intervention", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<etapes_intervention> etapesInterventions;
}
