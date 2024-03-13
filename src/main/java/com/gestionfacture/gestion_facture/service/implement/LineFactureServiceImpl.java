package com.gestionfacture.gestion_facture.service.implement;

import com.gestionfacture.gestion_facture.Dao.LineFactureDoa;
import com.gestionfacture.gestion_facture.models.LineFactureEntity;
import com.gestionfacture.gestion_facture.service.LineFactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LineFactureServiceImpl implements LineFactureService {

    private final LineFactureDoa lineFactureDoa;
    @Override
    public LineFactureEntity save(LineFactureEntity lineFactureEntity) {
        LineFactureEntity saved =lineFactureDoa.save(lineFactureEntity);
        return saved;
    }

    @Override
    public List<LineFactureEntity> findAll() {
        return lineFactureDoa.findAll();
    }
}
