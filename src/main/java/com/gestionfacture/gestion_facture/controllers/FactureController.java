package com.gestionfacture.gestion_facture.controllers;

import com.gestionfacture.gestion_facture.Dao.ClientDao;
import com.gestionfacture.gestion_facture.dto.FactureDto;
import com.gestionfacture.gestion_facture.dto.LinefactureDto;
import com.gestionfacture.gestion_facture.mappers.FactureMapper;
import com.gestionfacture.gestion_facture.models.FactureEntity;
import com.gestionfacture.gestion_facture.models.LineFactureEntity;
import com.gestionfacture.gestion_facture.models.LineFactureKey;
import com.gestionfacture.gestion_facture.service.ClientService;
import com.gestionfacture.gestion_facture.service.FactureService;
import com.gestionfacture.gestion_facture.service.LineFactureService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("factures")
public class FactureController {

    private final FactureService factureService;
    private final LineFactureService lineFactureService;
    private final FactureMapper factureMapper;

    @PostMapping
    public FactureEntity create(@RequestBody FactureDto factureDto){


        FactureEntity facture =factureMapper.mapToFacture(factureDto);


        List<LinefactureDto> linefactureDtoList = factureDto.getLineFacture();


        FactureEntity factureEntity =factureService.save(facture);
        if (linefactureDtoList != null)
        for (LinefactureDto linefactureDto:linefactureDtoList) {
            LineFactureEntity lineFacture=factureMapper.mapToLineFacture(linefactureDto);
            lineFacture.setFacture(factureEntity);

            //create a EmbeddedId
            LineFactureKey lineFactureKey = new LineFactureKey();
            lineFactureKey.setFactureId(facture.getId());
            lineFactureKey.setProduitId(lineFacture.getProduit().getId());

            lineFacture.setId(lineFactureKey);
            lineFactureService.save(lineFacture);

        }

        return facture;

    }

    @GetMapping
    public ResponseEntity<List<FactureEntity>> getFacture() {
        return new ResponseEntity<>( factureService.findAll(),HttpStatus.OK);
    }


}
