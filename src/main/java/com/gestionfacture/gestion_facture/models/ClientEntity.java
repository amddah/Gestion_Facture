package com.gestionfacture.gestion_facture.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientEntity implements Serializable {
    @Id()
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;

    @Column(name = "client_telephone")
    private String telephone;

    @OneToMany(mappedBy = "cilent",cascade = CascadeType.ALL)

    private List<FactureEntity> factures;
}
