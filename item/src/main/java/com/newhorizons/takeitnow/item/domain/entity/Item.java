package com.newhorizons.takeitnow.item.domain.entity;

public class Item {
    private Product product;
    private Long quantity;

    public Item() {
    }

    public Item(Product product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getTotal(){
        return product.getPrice() * quantity.doubleValue();
    }
}
