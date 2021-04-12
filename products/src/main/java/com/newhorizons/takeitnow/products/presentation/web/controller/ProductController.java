package com.newhorizons.takeitnow.products.presentation.web.controller;

import com.newhorizons.takeitnow.products.application.mainmodule.dto.ProductDto;
import com.newhorizons.takeitnow.products.application.mainmodule.service.IProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private Environment environment;

    @Autowired
    private IProductService productService;

    @GetMapping("/getAll")
    @ApiOperation("Get all products.")
    @ApiResponse(code = 200, message = "SUCCESS")
    public List<ProductDto> getAll(){
        return productService.getAll().stream().map(
                p -> {
                    p.setPortInUse(environment.getProperty("local.server.port"));
                    return p;
                }).collect(Collectors.toList());
    }

    @GetMapping("/getProduct/{productId}")
    @ApiOperation("Get product by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 404, message = "PRODUCT NOT FOUND")
    })
    public ProductDto getProduct(@ApiParam(value = "This is ID of the product", example = "5", required = true) @PathVariable("productId") long productId){
        ProductDto productDto = productService.getProduct(productId).get();
        productDto.setPortInUse(environment.getProperty("local.server.port"));
        return productDto;
    }
}
