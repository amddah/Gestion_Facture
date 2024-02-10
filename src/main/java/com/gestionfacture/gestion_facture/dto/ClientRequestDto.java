package com.gestionfacture.gestion_facture.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank
    @Size(min=2,max = 20 ,message = "The size must be between 2 and 20")
    private String nom;

    @NonNull
    @NotBlank
    @Size(min=2,max = 20,message = "The size must be between 2 and 20")
    private String prenom;

    @NonNull
    @Pattern(regexp = "^(\\+212|0)([ \\-_/]*)(\\d[ \\-_/]*){9}$", message = "format invalid")
    private String telephone;
}
