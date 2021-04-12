package com.newhorizons.takeitnow.item.infraestructure.repository.rest;

import com.newhorizons.takeitnow.item.application.mainmodule.dto.ItemDto;
import com.newhorizons.takeitnow.item.application.mainmodule.dto.ProductDto;
import com.newhorizons.takeitnow.item.application.mainmodule.mapper.IProductMapper;
import com.newhorizons.takeitnow.item.domain.entity.Product;
import com.newhorizons.takeitnow.item.domain.repository.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ItemRepository implements IItemRepository {

    @Autowired
    private RestTemplate restTemplateClient;

    @Autowired
    private IProductMapper productMapper;

    public List<ItemDto> getAll() {
        List<Product> products = Arrays.asList(restTemplateClient.getForObject("http://localhost:8001/TakeItNow/api/products/getAll", Product[].class));
        List<ProductDto> productsDto = productMapper.toProductsDto(products);
        return productsDto.stream().map(p -> new ItemDto(p, 1L)).collect(Collectors.toList());
    }

    public ItemDto getItem(long productId, long quantity) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("productId", Long.toString(productId));
        Product product = restTemplateClient.getForObject("http://localhost:8001/TakeItNow/api/products/getProduct/{productId}", Product.class, pathVariables);
        ProductDto productDto = productMapper.toProductDto(product);
        return new ItemDto(productDto, quantity);
    }
}
