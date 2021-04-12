package com.newhorizons.takeitnow.products.application.mainmodule.dto;

public class AuthResponseDto {
    private String jsonWebToken;

    public AuthResponseDto() {
    }

    public AuthResponseDto(String jsonWebToken) {
        this.jsonWebToken = jsonWebToken;
    }

    public String getJsonWebToken() {
        return jsonWebToken;
    }

    public void setJsonWebToken(String jsonWebToken) {
        this.jsonWebToken = jsonWebToken;
    }
}
