package com.gestionfacture.gestion_facture.service;

import com.gestionfacture.gestion_facture.dto.ClientRequestDto;
import com.gestionfacture.gestion_facture.dto.ClientResponseDto;

import java.util.List;

public interface ClientService {

    ClientResponseDto save(ClientRequestDto clientRequestDto);

    ClientResponseDto findById(Integer id);

    ClientResponseDto findByNom(String nom);

    void delete(Integer id);

    ClientResponseDto update(ClientRequestDto clientRequestDto,Integer id);


    List<ClientResponseDto> findAll();
}
