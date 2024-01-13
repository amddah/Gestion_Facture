package com.gestionfacture.gestion_facture.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity implements Serializable {

    @Id
    private Integer userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = "User_Roles",joinColumns =@JoinColumn(name = "userId"),
    inverseJoinColumns = @JoinColumn(name="roleId")
    )
    private List<RoleEntity> roles;

    @OneToOne
    private UserProfil profil;
}
