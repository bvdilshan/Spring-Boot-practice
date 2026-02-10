package com.example.posapi.api;

import com.example.posapi.dto.request.CustomerRequestDto;

public class CustomerController {
    public String saveCustomer(CustomerRequestDto dto) {
        return "Customer saved successfully";
    }
    
}
