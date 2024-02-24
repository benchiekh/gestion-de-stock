package com.iheb.gestiondestock.repository;

import com.iheb.gestiondestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
