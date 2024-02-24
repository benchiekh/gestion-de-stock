package com.iheb.gestiondestock.repository;

import com.iheb.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient , Integer> {
}
