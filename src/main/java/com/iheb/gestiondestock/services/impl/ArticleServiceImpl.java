package com.iheb.gestiondestock.services.impl;

import com.iheb.gestiondestock.dto.ArticleDto;
import com.iheb.gestiondestock.exception.EntityNotFoundException;
import com.iheb.gestiondestock.exception.ErrorCodes;
import com.iheb.gestiondestock.exception.InvalidEntityException;
import com.iheb.gestiondestock.model.Article;
import com.iheb.gestiondestock.repository.ArticleRepository;
import com.iheb.gestiondestock.services.ArticleService;
import com.iheb.gestiondestock.validator.ArticleValidator;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl  implements ArticleService {
    private ArticleRepository articleRepository;

    @Autowired
    public  ArticleServiceImpl (ArticleRepository articleRepository)
    {
        this.articleRepository = articleRepository;
    }
    @Override
    public ArticleDto save(ArticleDto articleDto) {


        List<String> errors = ArticleValidator.validator(articleDto);
        if(!errors.isEmpty()){
            log.error("Article is not valid{}", articleDto);
            throw new InvalidEntityException("l'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);

        }
        return ArticleDto.fromEntity(
                articleRepository.save(
                        articleDto.toEntity(articleDto)
                )
        );
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id == null){
            log.error("Article id is nul ");
        return null
        ;
        }
        Optional<Article> article = articleRepository.findById(id);

        ArticleDto dto = ArticleDto.fromEntity(article.get());


        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("Aucune article avec l'id ="+id+" n'ete trouve dans la base ",
                        ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(StringUtils.isNullOrEmpty(codeArticle)){
            log.error("Article Code is null ");
            return  null;
        }

        Optional<Article> article = articleRepository.findByCodeArticle(codeArticle);


        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "aucune article de code ="+ codeArticle + " nest pas trouver dans la base de donne ", ErrorCodes.ARTICLE_NOT_FOUND));

    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
    log.error("Article id is null ");
    return ;
}
        articleRepository.deleteById(id);
    }
}
