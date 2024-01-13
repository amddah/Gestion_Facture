package com.gestionfacture.gestion_facture.controllers;

import com.gestionfacture.gestion_facture.dto.ClientRequestDto;
import com.gestionfacture.gestion_facture.dto.ClientResponseDto;
import com.gestionfacture.gestion_facture.service.ClientService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientResponseDto> getClient(){
        return clientService.findAll();
    }

    @PostMapping
    public ClientResponseDto save(@RequestBody ClientRequestDto clientRequestDto){
        return clientService.save(clientRequestDto);
    }

    @GetMapping("/id/{id}")
    public ClientResponseDto findById(@PathVariable Integer id) {
        return clientService.findById(id);
    }

    @GetMapping("/nom/{nom}")
    public ClientResponseDto findByNom(@PathVariable String nom) {
        return clientService.findByNom(nom);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Integer id) {
        clientService.delete(id);
    }

    @PutMapping("/id/{id}")
    public ClientResponseDto update(@RequestBody ClientRequestDto clientRequestDto,@PathVariable Integer id) {
        return clientService.update(clientRequestDto, id);
    }

}
