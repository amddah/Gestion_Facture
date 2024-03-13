package com.gestionfacture.gestion_facture.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FactureDto {

    private String ref;

    private Integer cin;

    List<LinefactureDto> lineFacture;
}
