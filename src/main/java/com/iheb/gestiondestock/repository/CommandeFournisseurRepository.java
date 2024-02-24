package com.iheb.gestiondestock.repository;

import com.iheb.gestiondestock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {
}
