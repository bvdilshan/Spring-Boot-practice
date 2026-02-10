package com.example.posapi.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.posapi.dto.request.CustomerRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @PostMapping
    public String saveCustomer(@RequestBody CustomerRequestDto dto)
     {
        return "Customer saved successfully: " + dto;
    }
    @GetMapping("/{id}")
    public String getCustomerById(@PathVariable String id) {
        return "Customer details for ID: " + id;
    }
    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable String id, @RequestBody CustomerRequestDto dto) {
        return "Customer with ID: " + id + " updated successfully with details: " + "{" + dto + "}";
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable String id) {
        return "Customer with ID: " + id + " deleted successfully."; 
        
    }
    @GetMapping
    public String getAllCustomers() {
        return "List of all customers.";
    }   
    
}
