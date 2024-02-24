package com.iheb.gestiondestock.validator;

import com.iheb.gestiondestock.dto.CategoryDto;
import com.mysql.cj.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validator(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();
        if((categoryDto == null) || StringUtils.isNullOrEmpty(categoryDto.getCodeCategory())){
            errors.add("veuiller renseigner le code de la categorie");

        }
  return errors ;
    }
}
