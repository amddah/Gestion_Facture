package com.gestionfacture.gestion_facture.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public final class LineFactureKey implements Serializable {

    private static final long serialVersionUID = 4722352116317893282L;


    @Column(name="facture_id")
    private Integer factureId;

    @Column(name="produit_id")
    private Integer produitId;
}
