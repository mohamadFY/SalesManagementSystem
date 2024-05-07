package com.company.salesManagementSystem.service;

import com.company.salesManagementSystem.model.Product;
import com.company.salesManagementSystem.model.Sales;
import com.company.salesManagementSystem.repo.SalesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalesService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private SalesRepository salesRepository;

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Transactional
    public Sales addSale(Sales sale) {
        logger.info("Adding Sale: {}", sale);
        sale.setTotal(0);
        for (Product p : sale.getProducts()) {
            sale.setTotal(sale.getTotal() + p.getPrice());
        }
        Sales saved = salesRepository.save(sale);
        logger.info("Sale added successfully: {}", saved);
        return saved;
    }


    @Transactional
    public Sales editSale(Sales sale) {
        logger.info("Editing Sale: {}", sale);
        Sales edit = salesRepository.findById(sale.getId()).orElseThrow();
        edit.setProducts(sale.getProducts());
        edit.setTotal(0);
        for (Product p : edit.getProducts()) {
            edit.setTotal(edit.getTotal() + p.getPrice());
        }
        Sales saved = salesRepository.save(edit);
        logger.info("Sale Edited successfully: {}", saved);
        return saved;

    }


}
