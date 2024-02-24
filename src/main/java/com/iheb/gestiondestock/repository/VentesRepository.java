package com.iheb.gestiondestock.repository;

import com.iheb.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentesRepository extends JpaRepository<Ventes, Integer> {
}
