package com.projet.springsecurity.type_intervention;


import java.util.Set;

import com.projet.springsecurity.Etapes.Etape;

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
public class Type_intervention {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    @Column(nullable = false)
    private String desc_type;
    
    @OneToMany(mappedBy = "type_intervention", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
private Set<Etape> etapes;
}
