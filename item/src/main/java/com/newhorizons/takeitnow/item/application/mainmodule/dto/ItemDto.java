package com.newhorizons.takeitnow.item.application.mainmodule.dto;

public class ItemDto {
    private ProductDto product;
    private Long quantity;

    public ItemDto() {
    }

    public ItemDto(ProductDto product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getTotal(){
        return product.getPrice() * quantity;
    }
}
