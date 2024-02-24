package com.iheb.gestiondestock.controller;

import com.iheb.gestiondestock.controller.api.ClientApi;
import com.iheb.gestiondestock.dto.ClientDto;
import com.iheb.gestiondestock.services.ClientService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {

    private ClientService clientService ;

    public ClientController( ClientService clientService) {
        this.clientService = clientService ;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {

        clientService.delete(id);
    }
}
