package com.iheb.gestiondestock.services.impl;

import com.iheb.gestiondestock.dto.ClientDto;
import com.iheb.gestiondestock.dto.EntrepriseDto;
import com.iheb.gestiondestock.exception.EntityNotFoundException;
import com.iheb.gestiondestock.exception.ErrorCodes;
import com.iheb.gestiondestock.exception.InvalidEntityException;
import com.iheb.gestiondestock.model.Client;
import com.iheb.gestiondestock.repository.ClientRepository;
import com.iheb.gestiondestock.services.ClientService;
import com.iheb.gestiondestock.validator.ClientValidator;
import com.mysql.cj.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements  ClientService {
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validator(clientDto);
        if(!errors.isEmpty()){
            log.error("client is not valid",clientDto);
            throw new InvalidEntityException("client n'est pas valid ", ErrorCodes.CLIENT_NOT_VALID,errors);

        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));
    }



    @Override
    public ClientDto findById(Integer id) {
        if(id == null) {
            log.error("id is null");
            return null;
        }
        Optional<Client> client = clientRepository.findById(id);
        ClientDto clientDto = ClientDto.fromEntity(client.get());
        return Optional.of(clientDto).orElseThrow(()->
                new EntityNotFoundException("aucune client avec cette id "+ id + "dans la base",ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("id is null");
            return;
        }
        clientRepository.deleteById(id);
    }
}
