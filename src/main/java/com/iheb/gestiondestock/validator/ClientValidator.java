package com.iheb.gestiondestock.validator;

import com.iheb.gestiondestock.dto.ClientDto;
import com.mysql.cj.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validator(ClientDto clientDto) {
        List<String> errors = new ArrayList<>();
        if(clientDto == null){
            errors.add("veuiller saisir nom de la client ");
            errors.add("veuiller saisir prenom de la client ");
            errors.add("veuiller saisir email de la client ");
            errors.add("veuiller saisir numero de la client ");
            return errors ;
        }


        if (StringUtils.isNullOrEmpty(clientDto.getNom())) {
            errors.add("veuiller saisir nom de la client ");
        }

        if (StringUtils.isNullOrEmpty(clientDto.getPrenom())) {
            errors.add("veuiller saisir prenom de la client ");
        }

        if (StringUtils.isNullOrEmpty(clientDto.getMail())) {
            errors.add("veuiller saisir email de la client ");
        }

        if (StringUtils.isNullOrEmpty(clientDto.getNumTel())) {
            errors.add("veuiller saisir numero de la client ");
        }
        return errors;

    }
}
