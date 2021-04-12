package com.newhorizons.takeitnow.item.infraestructure.repository.feign;

import com.newhorizons.takeitnow.item.application.mainmodule.dto.ItemDto;
import com.newhorizons.takeitnow.item.application.mainmodule.dto.ProductDto;
import com.newhorizons.takeitnow.item.application.mainmodule.mapper.IProductMapper;
import com.newhorizons.takeitnow.item.domain.entity.Product;
import com.newhorizons.takeitnow.item.domain.repository.IItemRepository;
import com.newhorizons.takeitnow.item.infraestructure.feign.IProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository("repositoryFeign")
public class ItemRepository implements IItemRepository {

    @Autowired
    private IProductFeign productFeign;

    @Autowired
    private IProductMapper productMapper;

    public List<ItemDto> getAll() {
        List<Product> products = productFeign.getAll();
        List<ProductDto> productsDto = productMapper.toProductsDto(products);
        return productsDto.stream().map(p -> new ItemDto(p, 1L)).collect(Collectors.toList());
    }

    public ItemDto getItem(long productId, long quantity) {
        Product product = productFeign.getProduct(productId);
        ProductDto productDto = productMapper.toProductDto(product);
        return new ItemDto(productDto, quantity);
    }
}
