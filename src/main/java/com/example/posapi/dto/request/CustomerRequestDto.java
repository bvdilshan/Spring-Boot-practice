package com.example.posapi.dto.request;


public class CustomerRequestDto {
    private String name;
    private String salary;
    private String address;


    
    public CustomerRequestDto() {
    }
    public CustomerRequestDto(String name, String salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "CustomerRequestDto [name=" + name + ", salary=" + salary + ", address=" + address + "]";
    }
    

    
}