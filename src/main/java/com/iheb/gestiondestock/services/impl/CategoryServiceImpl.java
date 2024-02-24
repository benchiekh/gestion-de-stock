package com.iheb.gestiondestock.services.impl;

import com.iheb.gestiondestock.dto.CategoryDto;
import com.iheb.gestiondestock.exception.EntityNotFoundException;
import com.iheb.gestiondestock.exception.ErrorCodes;
import com.iheb.gestiondestock.exception.InvalidEntityException;
import com.iheb.gestiondestock.model.Category;
import com.iheb.gestiondestock.repository.ArticleRepository;
import com.iheb.gestiondestock.repository.CategoryRepository;
import com.iheb.gestiondestock.services.CategoryService;
import com.iheb.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
   private CategoryRepository categoryRepository ;

   @Autowired
   public CategoryServiceImpl(CategoryRepository categoryRepository){
       this.categoryRepository = categoryRepository ;
   }
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validator(categoryDto);
        if (!errors.isEmpty() ){
            log.error("Article is not valid{}", categoryDto);
            throw  new InvalidEntityException("category n'est pas valid" , ErrorCodes.ARTICLE_NOT_FOUND,errors);

        }


        return CategoryDto.fromEntity(
                categoryRepository.save(CategoryDto.toEntity(categoryDto))
        );
    }

    @Override
    public CategoryDto findById(Integer id) {
       if(id == null ){
           log.error("id is null");
           return null ;
       }

        Optional<Category> category = categoryRepository.findById(id);
       CategoryDto categoryDto = CategoryDto.fromEntity(category.get());
       return  Optional.of(categoryDto).orElseThrow(()->
               new EntityNotFoundException("aucune category avec cette id"+ id + "dans la base "
                       ,ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto findByCodeCategory(String codeCategory) {
       if (!StringUtils.isEmpty(codeCategory)){
           log.error("code is null");
           return null;
       }
       Optional<Category> category = categoryRepository.findByCodeCategory(codeCategory);
       CategoryDto categoryDto = CategoryDto.fromEntity(category.get());

        return Optional.of(categoryDto).orElseThrow(()->
                new EntityNotFoundException("aucune category avec cette code"+ codeCategory + "dans la base" ,
                        ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

       if (id == null){
           log.error("cateogory not found");
           return ;

       }
       categoryRepository.deleteById(id);

    }
}
