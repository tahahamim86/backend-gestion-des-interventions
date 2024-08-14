 package com.projet.springsecurity.type_intervention;

import org.springframework.stereotype.Service;

@Service
public class Type_interventionServiceImpl implements Type_interventionService {
    Type_interventionRepository type_interventionRepository;

    @Override
    public Type_intervention add_typeIn(Type_intervention typeIntervention) {

if(typeIntervention==null){
    throw new IllegalArgumentException("there is no Type_intervention");
}  
return type_interventionRepository.save(typeIntervention);  }

}
