package com.projet.springsecurity.intervention;

import org.springframework.stereotype.Service;
@Service
public class InterventionServiceImpl implements InterventionService{
    private InterventionRepository interventionRepository;

@Override
public Intervention add_intervention(Intervention intervention){
if(intervention==null){
    return null;
}
return interventionRepository.save(intervention);
 }


}
