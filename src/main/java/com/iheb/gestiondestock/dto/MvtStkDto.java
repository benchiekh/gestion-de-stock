package com.iheb.gestiondestock.dto;

import com.iheb.gestiondestock.model.Article;
import com.iheb.gestiondestock.model.MvStk;
import com.iheb.gestiondestock.model.TypeMvtStk;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {
    private  Integer id ;
    private Instant dateMvt;

    private BigDecimal quantite ;



    private ArticleDto article ;


    private TypeMvtStk typeMvt;

    private Integer idEntreprise;

    public static MvtStkDto fromEntity(MvStk mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }

    public static MvStk toEntity(MvtStkDto dto) {
        if (dto == null) {
            return null;
        }

        MvStk mvtStk = new MvStk();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
        mvtStk.setTypeMvt(dto.getTypeMvt() );
        mvtStk.setIdEntreprise(dto.getIdEntreprise());
        return mvtStk;
    }
}
