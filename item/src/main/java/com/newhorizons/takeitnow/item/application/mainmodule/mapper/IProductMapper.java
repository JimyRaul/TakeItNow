package com.newhorizons.takeitnow.item.application.mainmodule.mapper;

import com.newhorizons.takeitnow.item.application.mainmodule.dto.ProductDto;
import com.newhorizons.takeitnow.item.domain.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    @Mappings({
            @Mapping(source = "productId", target = "sku"),
            @Mapping(source = "description", target = "name")
    })
    ProductDto toProductDto(Product product);

    List<ProductDto> toProductsDto(List<Product> products);

    @InheritInverseConfiguration
    Product toProduct(ProductDto productDto);

}
