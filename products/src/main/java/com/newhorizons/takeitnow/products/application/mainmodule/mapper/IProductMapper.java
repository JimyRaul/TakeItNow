package com.newhorizons.takeitnow.products.application.mainmodule.mapper;

import com.newhorizons.takeitnow.products.application.mainmodule.dto.ProductDto;
import com.newhorizons.takeitnow.products.domain.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price", target = "price"),
            @Mapping(target = "portInUse", ignore = true)
    })
    ProductDto toProductDto(Product product);

    List<ProductDto> toProductsDto(List<Product> products);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "createAt", ignore = true)
    })
    Product toProduct(ProductDto productDto);
}
