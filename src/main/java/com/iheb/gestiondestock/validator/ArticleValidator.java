package com.iheb.gestiondestock.validator;

import com.iheb.gestiondestock.dto.ArticleDto;
import com.mysql.cj.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validator(ArticleDto articleDto){
        List<String> errors = new ArrayList<>();

        if(articleDto == null){
            errors.add("veuiller saisir le code de larticle ");
            errors.add("veuiller saisir le designation  ");
            errors.add("veuiller saisir le pric unitaire ");
            errors.add("veuiller saisir  le taux tva  ");
            errors.add("veuiller saisir le prix ttc  ");
            errors.add("veuiller selectionner une categories");
            return errors ;

        }
        if(StringUtils.isNullOrEmpty(articleDto.getCodeArticle())){
            errors.add("veuiller saisir le code de larticle ");
        }
        if(StringUtils.isNullOrEmpty(articleDto.getDesignation())){
            errors.add("veuiller saisir le designation  ");
        }
        if(articleDto.getPrixUnitaireHt() == null){
            errors.add("veuiller saisir le pric unitaire ");
        }
        if(articleDto.getTauxTva() == null){
            errors.add("veuiller saisir  le taux tva  ");
        }
        if(articleDto.getPrixunitaireTtc()== null){
            errors.add("veuiller saisir le prix ttc  ");
        }
        if(articleDto.getCategory() == null){
            errors.add("veuiller selectionner une categories");
        }
        return errors ;


    }


}
