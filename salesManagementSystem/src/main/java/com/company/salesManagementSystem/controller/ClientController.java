package com.company.salesManagementSystem.controller;

import com.company.salesManagementSystem.model.Client;
import com.company.salesManagementSystem.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping("")
    public ResponseEntity<?> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClient(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addClient(@Valid @RequestBody Client client) {
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<?> editClient(@Valid @RequestBody Client client) {
        return new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable long id) {
        return new ResponseEntity<>(clientService.delete(id), HttpStatus.OK);
    }
}
