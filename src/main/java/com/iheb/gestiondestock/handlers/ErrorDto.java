package com.iheb.gestiondestock.handlers;

import com.iheb.gestiondestock.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpCode ;
    private ErrorCodes code ;
    private  String message ;
    private List<String> errors = new ArrayList<>() ;
}
