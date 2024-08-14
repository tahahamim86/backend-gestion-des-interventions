package com.projet.springsecurity.Etapes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
@Data
@Service
public class EtapeServiceImp implements EtapeService {

private final EtapeRepository etapeRepository;
    @Override
    public List<Etape> getAllEtapes() {
    return this.etapeRepository.findAll();
    }

    @Override
    public Etape getEtapeById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return this.etapeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etape with id: " + id + " not found"));   }

    @Override
    public Etape saveEtape(Etape etape) {
        if (etape == null) {
            throw new IllegalArgumentException("etape cannot be null");
        }
        return this.etapeRepository.save(etape);   
    }

    @Override
    public Etape updateUser(Long id, Etape etape) {
        if (id == null || etape == null) {
            throw new IllegalArgumentException("ID or Etape cannot be null");
        }
    
        Etape existingEtape = getEtapeById(id);
        
        if (existingEtape == null) {
            throw new EntityNotFoundException("Etape not found with id: " + id);
        }
    
        existingEtape.setDesignation(etape.getDesignation());
    
        return this.etapeRepository.save(existingEtape);   }

    @Override
    public boolean deleteEtape(Long id) {
            Optional<Etape> etapeOptional = etapeRepository.findById(id);
        if (etapeOptional.isPresent()) {
            Etape etape = etapeOptional.get();
            if (etape != null ) {
                etapeRepository.deleteById(id);
                return true;
            } 
        }
        return false;
    }

}
