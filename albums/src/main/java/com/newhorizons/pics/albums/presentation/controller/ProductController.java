package com.newhorizons.pics.albums.presentation.controller;

import com.newhorizons.pics.albums.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public String getProduct(){
        return productService.getProducts();
    }
}
