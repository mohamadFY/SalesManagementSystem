package com.company.salesManagementSystem.controller;

import com.company.salesManagementSystem.model.Sales;
import com.company.salesManagementSystem.service.SalesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/sales")
public class SalesController {


    @Autowired
    private SalesService salesService;

    @GetMapping("")
    public ResponseEntity<?> getAllSales() {
        return new ResponseEntity<>(salesService.getAllSales(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addSale(@Valid @RequestBody Sales sales) {
        return new ResponseEntity<>(salesService.addSale(sales), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<?> editSale(@Valid @RequestBody Sales sales) {
        return new ResponseEntity<>(salesService.editSale(sales), HttpStatus.OK);
    }


}
