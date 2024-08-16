package com.projet.springsecurity.intervention;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/interventions")
public class InterventionController {
private InterventionServiceImpl interventionServiceImpl;
public InterventionController(InterventionServiceImpl interventionServiceImpl){
    this.interventionServiceImpl=interventionServiceImpl;
}
  @PostMapping
    public ResponseEntity<Intervention> createIntervention(@RequestBody @Valid Intervention intervention){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                interventionServiceImpl.add_intervention(intervention)
        );
    }
}
