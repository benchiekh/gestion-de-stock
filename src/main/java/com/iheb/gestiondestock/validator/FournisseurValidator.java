package com.iheb.gestiondestock.validator;


import com.iheb.gestiondestock.dto.FournisseurDto;
import com.mysql.cj.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validator(FournisseurDto fournisseurDto) {
        List<String> errors = new ArrayList<>();
        if(fournisseurDto == null){
            errors.add("veuiller saisir nom de la fournisseur ");
            errors.add("veuiller saisir prenom de la fournisseur");
            errors.add("veuiller saisir email de la fournisseur ");
            errors.add("veuiller saisir numero de la fournisseur ");
            return errors ;
        }


        if (StringUtils.isNullOrEmpty(fournisseurDto.getNom())) {
            errors.add("veuiller saisir nom de la la fournisseur");
        }

        if (StringUtils.isNullOrEmpty(fournisseurDto.getPrenom())) {
            errors.add("veuiller saisir prenom de la fournisseur");
        }

        if (StringUtils.isNullOrEmpty(fournisseurDto.getMail())) {
            errors.add("veuiller saisir email de la fournisseur");
        }

        if (StringUtils.isNullOrEmpty(fournisseurDto.getNumTel())) {
            errors.add("veuiller saisir numero de la fournisseur");
        }
        return errors;

    }


}
