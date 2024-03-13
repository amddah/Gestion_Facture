package com.gestionfacture.gestion_facture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDto {



    private Integer id;

    private String libille;

    private String ref;


    private BigDecimal prix;


    private double quantite_stock;
}
