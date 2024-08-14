package com.projet.springsecurity.etapes_interventions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/etapes_intervention")
public class Etapes_interventionController {

    Etapes_InterventionServiceImpl etapes_InterventionServiceImpl;
    Etapes_interventionController(Etapes_InterventionServiceImpl etapes_InterventionServiceImpl){
        this.etapes_InterventionServiceImpl=etapes_InterventionServiceImpl;
    }
    @PutMapping("/{id}")
    public ResponseEntity<etapes_intervention> updateStatus(@PathVariable Long id, @RequestBody etapes_intervention etapes_intervention) {
        
         try {
            etapes_intervention updatedEtapes_int = etapes_InterventionServiceImpl.update_status(etapes_intervention, id);
            return ResponseEntity.ok(updatedEtapes_int);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(null); // You can handle this more gracefully
        }
    }
}
