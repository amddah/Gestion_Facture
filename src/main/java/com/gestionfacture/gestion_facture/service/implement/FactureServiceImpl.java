package com.gestionfacture.gestion_facture.service.implement;

import com.gestionfacture.gestion_facture.Dao.FactureDoa;
import com.gestionfacture.gestion_facture.dto.FactureDto;
import com.gestionfacture.gestion_facture.models.FactureEntity;
import com.gestionfacture.gestion_facture.service.FactureService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {

    private final FactureDoa factureDoa;
    @Override
    public FactureEntity save(FactureEntity factureEntity) {
        FactureEntity saved = factureDoa.save(factureEntity);
        return saved;
    }

    @Override
    public List<FactureEntity> findAll() {
        return factureDoa.findAll();
    }
}
