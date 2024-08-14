package com.projet.springsecurity.Etapes;

import java.util.Set;

import com.projet.springsecurity.etapes_interventions.etapes_intervention;
import com.projet.springsecurity.type_intervention.Type_intervention;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Etape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String Designation;
    @OneToMany(mappedBy = "etape", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<etapes_intervention> etapes_interventions;
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_intervention_id", nullable = false)
    private Type_intervention type_intervention;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }
}
