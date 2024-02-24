package com.iheb.gestiondestock.repository;

import com.iheb.gestiondestock.model.Article;
import com.iheb.gestiondestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByCodeCategory(String codeCategory);

}
