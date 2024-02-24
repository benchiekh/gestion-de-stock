package com.iheb.gestiondestock.validator;

import com.iheb.gestiondestock.dto.UtilisateurDto;
import com.mysql.cj.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();


        if(utilisateurDto == null){
            errors.add("veuiller renseigner le nom d utilisateur ");
            errors.add("veuiller renseigner le prenom d utilisateur ");
            errors.add("veuiller renseigner le mot de passe  d utilisateur ");
            errors.add("veuiller renseigner le adresse  d utilisateur ");
            return errors ;
        }
        if (StringUtils.isNullOrEmpty(utilisateurDto.getNom())) {
            errors.add("veuiller renseigner le nom d utilisateur ");
        }
        if (StringUtils.isNullOrEmpty(utilisateurDto.getPrenom())) {
            errors.add("veuiller renseigner le prenom d utilisateur ");
        }
        if (StringUtils.isNullOrEmpty(utilisateurDto.getEmail())) {
            errors.add("veuiller renseigner l email utilisateur ");
        }
        if (StringUtils.isNullOrEmpty(utilisateurDto.getMotDePasse())) {
            errors.add("veuiller renseigner le mot de passed utilisateur ");
        }
        if ((utilisateurDto.getDateDeNaissance() == null)) {
            errors.add("veuiller saisir la date de naissance  d utilisateur ");
        }
        if ((utilisateurDto.getAdresse() == null)) {
            errors.add("veuiller renseigner le nom d utilisateur ");
        }
        if (StringUtils.isNullOrEmpty(utilisateurDto.getAdresse().getAdresse1())) {
            errors.add("veuiller renseigner le adresse 1d utilisateur ");
        }
        if (StringUtils.isNullOrEmpty(utilisateurDto.getAdresse().getCodePostale())) {
            errors.add("veuiller renseigner le code postal d utilisateur ");
        }
        if (StringUtils.isNullOrEmpty(utilisateurDto.getAdresse().getVille())) {
            errors.add("veuiller renseigner le ville d utilisateur ");
        }
        if (StringUtils.isNullOrEmpty(utilisateurDto.getAdresse().getPays())) {
            errors.add("veuiller renseigner le pay d utilisateur ");
        }

        return errors;
    }
}
