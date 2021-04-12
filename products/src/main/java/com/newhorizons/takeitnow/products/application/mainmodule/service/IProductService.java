package com.newhorizons.takeitnow.products.application.mainmodule.service;

import com.newhorizons.takeitnow.products.application.mainmodule.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductDto> getAll();
    Optional<ProductDto> getProduct(long productId);
}
