package com.gestionfacture.gestion_facture.service;

import com.gestionfacture.gestion_facture.dto.ProduitDto;

import java.util.List;

public interface ProduitService {

    ProduitDto save(ProduitDto produitDto);

    ProduitDto update(ProduitDto produitDto);

    int delete(String ref);

    ProduitDto findByRef(String ref);

    List<ProduitDto> findAll();

}
