package com.gestionfacture.gestion_facture.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Entity

@Table(name = "Line_Facture")
@Data
@ToString

public class LineFactureEntity implements Serializable {

    @EmbeddedId
    private LineFactureKey id;

    @ManyToOne
    @MapsId("factureId")
    @JsonBackReference
    private FactureEntity facture;

    @ManyToOne
    @MapsId("produitId")
    private ProduitEntity produit;

    private double quantite;

}