package com.iheb.gestiondestock.repository;

import com.iheb.gestiondestock.model.MvStk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvstkRepository extends JpaRepository< MvStk, Integer> {
}
