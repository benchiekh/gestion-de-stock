package com.iheb.gestiondestock.repository;

import com.iheb.gestiondestock.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer>{

}
