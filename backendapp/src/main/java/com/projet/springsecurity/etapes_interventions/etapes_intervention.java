package com.projet.springsecurity.etapes_interventions;

import com.projet.springsecurity.Etapes.Etape;
import com.projet.springsecurity.intervention.Intervention;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class etapes_intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private boolean realise =false;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "intervention_id", nullable = false)
    private Intervention intervention;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "etape_id", nullable = false)
    private Etape etape;
    public void setId( Long id){
        this.id=id;
    }
    public Long getId(){
        return this.id;

    }
    public void setRealise(boolean realise){
        this.realise=realise;
    }
public boolean getRealise(){
    return this.realise;
}
}
