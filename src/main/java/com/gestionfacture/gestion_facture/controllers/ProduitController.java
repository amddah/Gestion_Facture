package com.gestionfacture.gestion_facture.controllers;

import com.gestionfacture.gestion_facture.dto.ProduitDto;
import com.gestionfacture.gestion_facture.service.ProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/produits")

public class ProduitController {

   private ProduitService produitService;
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping
    public ProduitDto save(@Valid @RequestBody ProduitDto produitDto) {
        return produitService.save(produitDto);
    }

    @DeleteMapping("/ref/{ref}")
    public int delete(@PathVariable String ref) {
        return produitService.delete(ref);
    }

    @GetMapping("/ref/{ref}")
    public ProduitDto findByRef(@PathVariable String ref) {
        return produitService.findByRef(ref);
    }

    @PutMapping
    public ProduitDto update(@Valid @RequestBody ProduitDto produitDto) {
        return produitService.update(produitDto);
    }

    @GetMapping
    public List<ProduitDto> findAll() {
        return produitService.findAll();
    }
}
