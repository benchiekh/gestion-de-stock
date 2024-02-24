package com.iheb.gestiondestock.controller;

import com.iheb.gestiondestock.controller.api.EntrepriseApi;
import com.iheb.gestiondestock.dto.EntrepriseDto;
import com.iheb.gestiondestock.services.EntrepriseService;

import java.util.List;

public class EntrepriseController implements EntrepriseApi {
    private EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService){
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        return entrepriseDto.save(entrepriseDto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return null;
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
