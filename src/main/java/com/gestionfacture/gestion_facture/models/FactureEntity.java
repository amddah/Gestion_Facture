package com.gestionfacture.gestion_facture.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Facture")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FactureEntity implements Serializable {

    @Id
    private Integer id;
    @Column(nullable = false)
    private String ref;
    @Column(nullable = false ,name = "Date_fac")
    private Date date;

    @ManyToOne
    private ClientEntity cilent;

    @OneToMany(mappedBy = "facture",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LineFactureEntity> lineFacture;

}
