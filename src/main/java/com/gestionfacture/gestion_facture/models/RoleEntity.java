package com.gestionfacture.gestion_facture.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Roles")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleEntity implements Serializable {

    @Id
    private Integer roleId;

    @Column(nullable = false)
    private String name;


    @ManyToMany
    @JoinTable(name = "User_Roles",joinColumns =@JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name="userId")
    )
    private List<UserEntity> users;
}
