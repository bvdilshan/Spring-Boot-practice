package com.example.posapi.api;

import com.example.posapi.dto.request.CustomerRequestDto;

public class CustomerController {
    public String saveCustomer(CustomerRequestDto dto) {
        return "Customer saved successfully: " + dto;
    }
    public String getCustomerById(String id) {
        return "Customer details for ID: " + id;
    }
    public String updateCustomer(String id, CustomerRequestDto dto) {
        return "Customer with ID: " + id + " updated successfully with details: " + "{" + dto + "}";
    }
    public String deleteCustomer(String id) {
        return "Customer with ID: " + id + " deleted successfully."; 
        
    }
    public String getAllCustomers() {
        return "List of all customers.";
    }   
    
}
