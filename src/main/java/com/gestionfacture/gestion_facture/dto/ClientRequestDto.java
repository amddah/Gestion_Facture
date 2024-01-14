package com.gestionfacture.gestion_facture.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

    @NonNull
    @Size(min=2,max = 20)
    private String nom;

    @NonNull
    @Size(min=2,max = 20)
    private String prenom;

    @NonNull
    private String telephone;
}
