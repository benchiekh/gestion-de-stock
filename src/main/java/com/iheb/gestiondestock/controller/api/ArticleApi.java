package com.iheb.gestiondestock.controller.api;

import com.iheb.gestiondestock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

import static com.iheb.gestiondestock.utils.Constants.APP_ROOT;

public interface ArticleApi {

    @PostMapping(value = APP_ROOT + "/articles/create")
    ArticleDto save(@RequestBody  ArticleDto articleDto);

    @GetMapping(value = APP_ROOT+"/articles/{idArticle}")
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}")
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = APP_ROOT + "/articles/all")
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + " articles/delete/{idArticle}")
    void delete(@PathVariable("idArticle") Integer id);
}
