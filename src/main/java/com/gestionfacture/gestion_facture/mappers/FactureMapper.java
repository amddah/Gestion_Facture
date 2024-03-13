package com.gestionfacture.gestion_facture.mappers;

import com.gestionfacture.gestion_facture.dto.ClientResponseDto;
import com.gestionfacture.gestion_facture.dto.FactureDto;
import com.gestionfacture.gestion_facture.dto.LinefactureDto;
import com.gestionfacture.gestion_facture.dto.ProduitDto;
import com.gestionfacture.gestion_facture.exception.EntityNotFoundException;
import com.gestionfacture.gestion_facture.models.ClientEntity;
import com.gestionfacture.gestion_facture.models.FactureEntity;
import com.gestionfacture.gestion_facture.models.LineFactureEntity;
import com.gestionfacture.gestion_facture.models.ProduitEntity;
import com.gestionfacture.gestion_facture.service.ClientService;
import com.gestionfacture.gestion_facture.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class FactureMapper {

    private final ClientService clientService;
    private final ProduitService produitService;
    private final ModelMapper modelMapper;
    public FactureEntity mapToFacture(FactureDto factureDto){
        FactureEntity facture = new FactureEntity();
        facture.setRef(factureDto.getRef());
        facture.setDate(new Date());

        ClientResponseDto client = clientService.findById(factureDto.getCin());
        ClientEntity clientEntity =modelMapper.map(client,ClientEntity.class);
        facture.setCilent(clientEntity);

        return facture;
    }

    public LineFactureEntity mapToLineFacture(LinefactureDto linefactureDto){

        LineFactureEntity lineFacture =new LineFactureEntity();
        ProduitDto produitDto = produitService.findByRef(linefactureDto.getRefproduit());
        ProduitEntity produitEntity =modelMapper.map(produitDto,ProduitEntity.class);
        lineFacture.setProduit(produitEntity);
        lineFacture.setQuantite(linefactureDto.getQuantite());
        return lineFacture;
    }
}
