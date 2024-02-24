package com.iheb.gestiondestock.services.impl;

import com.iheb.gestiondestock.dto.ClientDto;
import com.iheb.gestiondestock.dto.EntrepriseDto;
import com.iheb.gestiondestock.exception.EntityNotFoundException;
import com.iheb.gestiondestock.exception.ErrorCodes;
import com.iheb.gestiondestock.exception.InvalidEntityException;
import com.iheb.gestiondestock.model.Entreprise;
import com.iheb.gestiondestock.repository.EntrepriseRepository;
import com.iheb.gestiondestock.services.ClientService;
import com.iheb.gestiondestock.services.EntrepriseService;
import com.iheb.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class EntrepriseServiceImpl implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository ;

    public  EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository){
        this.entrepriseRepository = entrepriseRepository ;

    }



    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()){
            log.error("entreprise is not valid" ,entrepriseDto);
            throw new InvalidEntityException("Entreprise n'est pas valid" , ErrorCodes.ENTREPRISE_NOT_VALID,errors);

        }

        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto)));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if(id == null) {
            log.error("id is null");
            return null ;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        EntrepriseDto entrepriseDto = EntrepriseDto.fromEntity(entreprise.get());

        return Optional.of(entrepriseDto).orElseThrow(()->
                new EntityNotFoundException("entreprise not found avec cette id ",ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("id is null");
            return;
        }
        entrepriseRepository.deleteById(id);

    }
}
