package com.projet.springsecurity.Etapes;

import java.util.List;

public interface EtapeService {
  public List<Etape> getAllEtapes();
    public Etape getEtapeById(Long id);
    public Etape saveEtape(Etape etape);
    public Etape updateUser(Long id,Etape etape);
    public boolean deleteEtape(Long id);
}
