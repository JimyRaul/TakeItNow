package com.newhorizons.takeitnow.products.infraestructure.repository;

import com.newhorizons.takeitnow.products.application.mainmodule.dto.ProductDto;
import com.newhorizons.takeitnow.products.application.mainmodule.mapper.IProductMapper;
import com.newhorizons.takeitnow.products.domain.entity.Product;
import com.newhorizons.takeitnow.products.domain.repository.IProductRepository;
import com.newhorizons.takeitnow.products.infraestructure.crud.IProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private IProductCrudRepository productCrudRepository;

    @Autowired
    private IProductMapper productMapper;

    public List<ProductDto> getAll(){
        List<Product> products = ((List<Product>)productCrudRepository.findAll());
        return productMapper.toProductsDto(products);
    }

    public Optional<ProductDto> getProduct(long id){
        return productCrudRepository.findById(id).map(e -> productMapper.toProductDto(e));
    }
}
