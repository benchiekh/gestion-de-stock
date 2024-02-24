package com.iheb.gestiondestock.controller.api;

import com.iheb.gestiondestock.dto.ClientDto;
import com.iheb.gestiondestock.dto.EntrepriseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.iheb.gestiondestock.utils.Constants.APP_ROOT;

public interface EntrepriseApi {
    @PostMapping(value = APP_ROOT +"/entreprise/create")
    EntrepriseDto save(@RequestBody EntrepriseDto entrepriseDto);

    @GetMapping(value = APP_ROOT+ "/entreprise/{idEntreprise}")
    EntrepriseDto findById( Integer id) ;

    @GetMapping(value = APP_ROOT + "/entreprise/all")
    List<EntrepriseDto> findAll();

    @DeleteMapping(value = APP_ROOT+ "/entreprise/delete/{idEntreprise}")
    void delete(@PathVariable("idEntreprise") Integer id);
}
