package com.gestionfacture.gestion_facture.service;

import com.gestionfacture.gestion_facture.Dao.ClientDao;
import com.gestionfacture.gestion_facture.dto.ClientRequestDto;
import com.gestionfacture.gestion_facture.dto.ClientResponseDto;
import com.gestionfacture.gestion_facture.models.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImp implements  ClientService{

    private ClientDao clientDao;
    private ModelMapper modelMapper;

    public ClientServiceImp(ClientDao clientDao, ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {

        ClientEntity clientEntity = modelMapper.map(clientRequestDto,ClientEntity.class);

        ClientEntity saved = clientDao.save(clientEntity);
        return modelMapper.map(saved,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {

        ClientEntity clientEntity = clientDao.findById(id).orElse(null);
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        ClientEntity clientEntity = clientDao.findByNom(nom);
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        clientDao.deleteById(id);
    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) {

       Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
       if (clientEntityOptional.isPresent()){
           ClientEntity clientEntity = modelMapper.map(clientRequestDto,ClientEntity.class);
           clientEntity.setId(id);
           ClientEntity updated= clientDao.save(clientEntity);

           return modelMapper.map(updated,ClientResponseDto.class);
       }else {
           return null;
       }

    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll()
                .stream().map(el->modelMapper.map(el,ClientResponseDto.class))
                .collect(Collectors.toList());
    }
}
