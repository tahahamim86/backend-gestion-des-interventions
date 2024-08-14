package com.projet.springsecurity.type_intervention;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/type_interventions")
public class Type_interventionController {
@Autowired
private Type_interventionServiceImpl type_interventionServiceImpl;
@PostMapping
public ResponseEntity<Type_intervention> addtypeInt(@RequestBody Type_intervention type_intervention) {
    
    return new ResponseEntity<>(type_interventionServiceImpl.add_typeIn(type_intervention),HttpStatus.CREATED);
}

}
