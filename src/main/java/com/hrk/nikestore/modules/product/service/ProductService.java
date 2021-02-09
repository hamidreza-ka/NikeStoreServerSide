package com.hrk.nikestore.modules.product.service;

import com.hrk.nikestore.modules.product.model.Product;
import com.hrk.nikestore.modules.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(int sort) {

        switch (sort) {
            case 0:
                return productRepository.findProductsByLatest();
            case 1:
                return productRepository.findProductsByPopular();
            case 2:
                return productRepository.findProductsByHighestPrice();
            case 3:
                return productRepository.findProductsByLowestPrice();

            default:
                return productRepository.findAll();
        }

    }

    public List<Product> getProductsBySearch(String q) {
        return productRepository.findAllByTitle(q);
    }
}
