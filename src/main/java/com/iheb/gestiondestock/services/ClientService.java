package com.iheb.gestiondestock.services;

import com.iheb.gestiondestock.dto.ClientDto;
import com.iheb.gestiondestock.dto.EntrepriseDto;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto clientDto);



    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void delete(Integer id);
}
