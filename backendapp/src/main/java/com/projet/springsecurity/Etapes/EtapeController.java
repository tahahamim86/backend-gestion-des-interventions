package com.projet.springsecurity.Etapes;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/etapes")
public class EtapeController {
private final EtapeServiceImp etapeServiceImpl;

public EtapeController(EtapeServiceImp etapeServiceImpl){
    this.etapeServiceImpl=etapeServiceImpl;
}
@GetMapping()
@PreAuthorize("hasRole('RESPONSABLE') and hasAuthority('READ_ETAPE')")
public ResponseEntity<?> getAllUsers() {
    List<Etape> etapes = this.etapeServiceImpl.getAllEtapes();
    return new ResponseEntity<>(etapes, HttpStatus.OK);
}
    
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('RESPONSABLE') and hasAuthority('READ_ONE_ETAPE')")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Etape etape = this.etapeServiceImpl.getEtapeById(id);
        return new ResponseEntity<>(etape, HttpStatus.OK);
    }

    

        @PostMapping()
        @PreAuthorize("hasRole('RESPONSABLE') and hasAuthority('CREATE_ETAPE')")
    public ResponseEntity<?> addUser(@RequestBody Etape etape) {
        return new ResponseEntity<>(this.etapeServiceImpl.saveEtape(etape), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('RESPONSABLE') and hasAuthority('UPDATE_ONE_ETAPE')")
    public ResponseEntity<Etape> updateUser(@PathVariable Long id, @RequestBody Etape etape) {
        try {
            Etape updatedeEtape = etapeServiceImpl.updateUser(id, etape);
            return ResponseEntity.ok(updatedeEtape);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(null); // You can handle this more gracefully
        }
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('RESPONSABLE') and hasAuthority('DELETE_ONE_ETAPE')")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            boolean isDeleted = etapeServiceImpl.deleteEtape(id);
            if (!isDeleted) {
                return new ResponseEntity<>("Etape not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
