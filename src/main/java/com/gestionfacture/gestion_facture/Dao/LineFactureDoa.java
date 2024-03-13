package com.gestionfacture.gestion_facture.Dao;

import com.gestionfacture.gestion_facture.models.LineFactureEntity;
import com.gestionfacture.gestion_facture.models.LineFactureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineFactureDoa extends JpaRepository<LineFactureEntity, LineFactureKey> {

}
