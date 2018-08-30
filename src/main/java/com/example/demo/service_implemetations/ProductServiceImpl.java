package com.example.demo.service_implemetations;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);


    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        LOGGER.trace("Get all product");
        return productRepository.getAllByDeletedAtIsNotNull();
    }

    @Override
    public Product save(Product product) {
        if (product != null) {
            product = productRepository.save(product);
        }
        return product;
    }

    @Override
    public Product deactivate(Product product) {
        if (product != null) {
            product.setDeletedAt(new Timestamp(System.currentTimeMillis()));
            product = productRepository.save(product);
        }
        return product;
    }

    @Override
    public void delete(Product product) {
        if (product != null){
            productRepository.delete(product);
        }
    }
}
