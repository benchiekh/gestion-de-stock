package com.iheb.gestiondestock.controller.api;

import com.iheb.gestiondestock.dto.CategoryDto;
import com.iheb.gestiondestock.dto.ClientDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.iheb.gestiondestock.utils.Constants.APP_ROOT;

public interface ClientApi {
    @PostMapping(value = APP_ROOT +"/client/create")
    ClientDto save(@RequestBody ClientDto clientDto);

    @GetMapping(value = APP_ROOT+ "/client/{idClient}")
    ClientDto findById( Integer id) ;

    @GetMapping(value = APP_ROOT + "/client/all")
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT+ "/client/delete/{idClient}")
    void delete(@PathVariable("idClient") Integer id);
}
