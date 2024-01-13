package com.gestionfacture.gestion_facture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String telephone;
}
