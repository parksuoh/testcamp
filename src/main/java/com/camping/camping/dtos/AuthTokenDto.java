package com.camping.camping.dtos;

import jakarta.validation.constraints.NotBlank;

public class AuthTokenDto {

    @NotBlank
    private String token;

    private AuthTokenDto() {
    }

    public AuthTokenDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
