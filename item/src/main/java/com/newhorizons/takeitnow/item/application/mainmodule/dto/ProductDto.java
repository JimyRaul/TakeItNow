package com.newhorizons.takeitnow.item.application.mainmodule.dto;

public class ProductDto {
    private Long sku;
    private String name;
    private Double price;
    private String portInUse;

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
