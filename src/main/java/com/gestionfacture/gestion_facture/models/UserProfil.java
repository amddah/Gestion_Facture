package com.gestionfacture.gestion_facture.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Profil")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserProfil implements Serializable {

    @Id
    @GeneratedValue
    private Integer Id;


    private  String avatar;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity users;
}
