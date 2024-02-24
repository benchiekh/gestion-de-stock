package com.iheb.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mvstk")
public class MvStk extends AbstractEntity{

    @Column(name = "datemvt")
    private Instant dateMvt;

    @Column(name = "quantite")
    private BigDecimal quantite ;



    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article ;

    @Column(name = "typemvt")
    private TypeMvtStk typeMvt;

    @Column(name = "identreprise")
    private Integer idEntreprise ;


}
