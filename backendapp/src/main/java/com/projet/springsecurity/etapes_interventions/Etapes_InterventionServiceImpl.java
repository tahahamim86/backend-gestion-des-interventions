package com.projet.springsecurity.etapes_interventions;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Etapes_InterventionServiceImpl implements Etapes_interventionService {

    @Autowired
    private etapes_interventionRepository etapes_interventionRepository;

   

    @Override
    public etapes_intervention update_status(etapes_intervention etapes_intervention, Long id) {
        // TODO Auto-generated method stub
        if (id == null || etapes_intervention == null || etapes_intervention.getRealise() == false) {
            throw new IllegalArgumentException("ID or Etapes_Intervention or Realise cannot be null");
        }

        // Retrieve the existing entity from the database
        etapes_intervention existingEtape = etapes_interventionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etapes_Intervention not found with id: " + id));

        // Update existing entity with new details
        existingEtape.setRealise(etapes_intervention.getRealise());

        // Save the updated entity to the repository
        return etapes_interventionRepository.save(existingEtape);    }
}
