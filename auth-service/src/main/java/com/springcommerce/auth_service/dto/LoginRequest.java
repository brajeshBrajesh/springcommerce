package com.springcommerce.auth_service.dto;
import lombok.Data;

@Data
public  class LoginRequest{
    private String userName;
    private String password;
}