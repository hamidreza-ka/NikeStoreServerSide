package com.hrk.nikestore.modules.product.controller;

import com.hrk.nikestore.modules.product.model.Product;
import com.hrk.nikestore.modules.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Product> getProducts(@Param("sort") int sort){
        return productService.getProducts(sort);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    private List<Product> getProductsBySearch(@Param("q") String q){
        return productService.getProductsBySearch(q);
    }
}
