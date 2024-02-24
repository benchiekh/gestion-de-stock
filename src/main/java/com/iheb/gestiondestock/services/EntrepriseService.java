package com.iheb.gestiondestock.services;

import com.iheb.gestiondestock.dto.CategoryDto;
import com.iheb.gestiondestock.dto.EntrepriseDto;
import com.iheb.gestiondestock.model.Entreprise;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto entrepriseDto);

    EntrepriseDto findById(Integer id);

    List<EntrepriseDto> findAll();

    void delete(Integer id);
}
