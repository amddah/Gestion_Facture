package com.gestionfacture.gestion_facture.service;

import com.gestionfacture.gestion_facture.models.LineFactureEntity;

import java.util.List;

public interface LineFactureService {

    LineFactureEntity save(LineFactureEntity lineFactureEntity);

    List<LineFactureEntity> findAll();
}
