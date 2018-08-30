package com.example.demo.services;

import com.example.demo.entities.Product;

import java.util.List;

public interface ProductService extends BaseService<Product> {
    List<Product> getAll();
}
