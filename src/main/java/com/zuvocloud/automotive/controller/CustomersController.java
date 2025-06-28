package com.zuvocloud.automotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zuvocloud.automotive.dto.CustomersDTO;
import com.zuvocloud.automotive.entity.Customers;
import com.zuvocloud.automotive.services.CustomerServices;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    private CustomerServices customerServices;
    @GetMapping
    public ResponseEntity <List<CustomersDTO>> getAll(){
        List<CustomersDTO>customersDTOS = customerServices.getAll();
        return new ResponseEntity<>(customersDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customers> findById(@PathVariable ("id") int id){
        Customers customers = customerServices.findById(id);
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Customers>createCustomers(@RequestBody CustomersDTO customersDTO){
        Customers customers =customerServices.createCustomer(customersDTO);
        return new ResponseEntity<>(customers,HttpStatus.CREATED);
    }
    @PutMapping
    public  ResponseEntity<Customers>updateCustomers(@RequestBody CustomersDTO customersDTO){
        Customers customers = customerServices.updateCustomers(customersDTO);
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Customers>deleteCustomers(@PathVariable  int id){
        Customers deleteCustomers = customerServices.deleteCustomers(id);
        return  new ResponseEntity<>(deleteCustomers, HttpStatus.OK);
    }
}
