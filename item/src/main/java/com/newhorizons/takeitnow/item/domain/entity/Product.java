package com.newhorizons.takeitnow.item.domain.entity;

public class Product {
    private Long productId;
    private String description;
    private Double price;
    private String portInUse;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPortInUse() {
        return portInUse;
    }

    public void setPortInUse(String portInUse) {
        this.portInUse = portInUse;
    }
}
