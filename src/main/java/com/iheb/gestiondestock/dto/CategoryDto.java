package com.iheb.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iheb.gestiondestock.model.Article;
import com.iheb.gestiondestock.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CategoryDto {
    private  Integer id ;
    private String codeCategory ;

    private String designation ;
    @JsonIgnore
    private List<ArticleDto> articles ;

    public static CategoryDto fromEntity(Category category){
        if(category == null){
            // todo throw an exception
            return null ;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .codeCategory(category.getCodeCategory())
                .designation(category.getDesignation())
                .build();
    }

public static Category toEntity(CategoryDto categoryDto){
        if(categoryDto == null){
            return null ;
            // todo throw an exception
        }
        Category  category = new Category();
        category.setId(categoryDto.getId());
        category.setCodeCategory(categoryDto.getCodeCategory());
        category.setDesignation(categoryDto.getDesignation());
        return category ;
}
}
