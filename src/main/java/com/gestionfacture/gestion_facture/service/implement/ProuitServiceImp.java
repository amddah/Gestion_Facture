package com.gestionfacture.gestion_facture.service.implement;

import com.gestionfacture.gestion_facture.Dao.ProduitDao;
import com.gestionfacture.gestion_facture.dto.ProduitDto;
import com.gestionfacture.gestion_facture.exception.EntityAlreadyExistsException;
import com.gestionfacture.gestion_facture.exception.EntityNotFoundException;
import com.gestionfacture.gestion_facture.models.ProduitEntity;
import com.gestionfacture.gestion_facture.service.ProduitService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProuitServiceImp implements ProduitService {

    private  ProduitDao produitDao;
    private ModelMapper modelMapper;
    @Override
    public ProduitDto save(ProduitDto produitDto) {

        if (findByRef(produitDto.getRef())!= null) throw new EntityAlreadyExistsException("product Already exist !");

        ProduitEntity produitEntity = modelMapper.map(produitDto,ProduitEntity.class);
        ProduitEntity saved = produitDao.save(produitEntity);

        return modelMapper.map(saved,ProduitDto.class);
    }


    @Override
    public ProduitDto update(ProduitDto produitDto) {
        Optional<ProduitEntity> produitEntity = produitDao.findByRef(produitDto.getRef());

        if (produitEntity.isEmpty()) throw new EntityNotFoundException("The product update was not found.");
        produitEntity.get().setLibille(produitDto.getLibille());
        produitEntity.get().setPrix(produitDto.getPrix());
        produitEntity.get().setQuantite_stock(produitDto.getQuantite_stock());
        ProduitEntity saved = produitDao.save(produitEntity.get());
        return modelMapper.map(saved,ProduitDto.class);
    }

    @Transactional
    @Override
    public int delete(String ref) {

        return produitDao.deleteByRef(ref);
    }

    @Override
    public ProduitDto findByRef(String ref) {
       ProduitEntity produitEntity= produitDao.findByRef(ref).orElse(null);
      if (produitEntity == null) throw  new EntityNotFoundException("Product not found !");
      return modelMapper.map(produitEntity,ProduitDto.class);
    }

    @Override
    public List<ProduitDto> findAll() {

        return produitDao.findAll()
                .stream().map(el->modelMapper.map(el,ProduitDto.class))
                .collect(Collectors.toList());
    }
}
