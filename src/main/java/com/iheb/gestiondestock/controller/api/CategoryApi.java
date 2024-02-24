package com.iheb.gestiondestock.controller.api;

import com.iheb.gestiondestock.dto.CategoryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.iheb.gestiondestock.utils.Constants.APP_ROOT;

public interface CategoryApi {
    @PostMapping(value = APP_ROOT +"/category/create")
   CategoryDto save(@RequestBody  CategoryDto categoryDto);

   @GetMapping(value = APP_ROOT+ "/category/{idCateogory}")
   CategoryDto findById( Integer id) ;

   @GetMapping(value = APP_ROOT+"/category/{codeCategory}")
   CategoryDto findByCodeCategory(@PathVariable("codeCategory") String codeCategory) ;

   @GetMapping(value = APP_ROOT + "/category/all")
   List<CategoryDto> findAll();

   @DeleteMapping(value = APP_ROOT+ "/category/delete/{idCategory}")
   void delete(@PathVariable("idCategory") Integer id);

}
