package com.gestionfacture.gestion_facture.Dao;

import com.gestionfacture.gestion_facture.models.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureDoa extends JpaRepository<FactureEntity,Integer> {
}
