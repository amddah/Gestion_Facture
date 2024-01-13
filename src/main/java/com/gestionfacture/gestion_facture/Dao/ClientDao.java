package com.gestionfacture.gestion_facture.Dao;

import com.gestionfacture.gestion_facture.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity,Integer> {
    ClientEntity findByNom(String Nom);
}
