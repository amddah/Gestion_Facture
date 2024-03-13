package com.gestionfacture.gestion_facture.service;

import com.gestionfacture.gestion_facture.dto.FactureDto;
import com.gestionfacture.gestion_facture.models.FactureEntity;

import java.util.List;

public interface FactureService {

    FactureEntity save(FactureEntity factureEntity);

    List<FactureEntity> findAll();
}
