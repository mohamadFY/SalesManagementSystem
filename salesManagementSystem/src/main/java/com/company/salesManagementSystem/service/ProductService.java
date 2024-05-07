package com.company.salesManagementSystem.service;

import com.company.salesManagementSystem.model.Product;
import com.company.salesManagementSystem.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public Product addProduct(Product product) {
        logger.info("Adding product: {}", product);
        Product saved = productRepository.save(product);
        logger.info("Product added successfully: {}", saved);
        return saved;
    }

    @Transactional
    public Product updateProduct(Product newProduct) {
        logger.info("updating product: {}", newProduct);
        Product updated = productRepository.save(newProduct);
        logger.info("Product updated successfully: {}", updated);
        return updated;
    }

    @Transactional

    public boolean deleteProduct(long id) {
        logger.info("deleting product with id : {}", id);
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            logger.info("Product deleted successfully: {}", id);
            return true;
        }
        logger.info("Cant delete product", id);
        return false;
    }

}
