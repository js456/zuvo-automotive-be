package com.zuvocloud.automotive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zuvocloud.automotive.dto.CustomersDTO;
import com.zuvocloud.automotive.entity.Customers;
import com.zuvocloud.automotive.entity.Tenants;
import com.zuvocloud.automotive.repository.CustomersRepo;
import com.zuvocloud.automotive.repository.TenantsRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    private CustomersRepo customersRepo;

    @Autowired
    private TenantsRepo tenantsRepo;

    public List<CustomersDTO> getAll() {
        List<Customers>customers =customersRepo.findAll();
        List<CustomersDTO> customersDTOS = new ArrayList<>();
        for (Customers customer: customers){
            CustomersDTO customersDTO = new CustomersDTO();
            customersDTO.setId(customer.getId());
            customersDTO.setName(customer.getName());
            customersDTO.setPhone(customer.getPhone());
            customersDTO.setEmail(customer.getEmail());
            customersDTO.setAddress(customer.getAddress());
            customersDTO.setCreatedAt(customer.getCreatedAt());
         //   customer.setTenantId(customer.getTenantId());
            customersDTOS.add(customersDTO);
        }
        return customersDTOS;
    }

    public Customers findById(int id) {
        Customers customers = customersRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("customers not found with id"+id));
        return customers;
    }

    public Customers createCustomer(CustomersDTO customersDTO) {
        try{
            Customers customers = new Customers();
            customers.setId(customersDTO.getId());
            customers.setCreatedAt(customersDTO.getCreatedAt());
            customers.setPhone(customersDTO.getPhone());
            customers.setEmail(customersDTO.getEmail());
            customers.setAddress(customersDTO.getAddress());
            Tenants tenant = tenantsRepo.findById(customersDTO.getTenantId())
                    .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + customersDTO.getTenantId()));
            customers.setTenants(tenant);

            customers.setName(customersDTO.getName());
            Customers customers1 =customersRepo.save(customers);
            return customers1;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Customers updateCustomers(CustomersDTO customersDTO) {
        try {
            Customers customers = customersRepo.findById(customersDTO.getId())
                    .orElseThrow(()->new RuntimeException("customer not found with id"));
            customers.setId(customersDTO.getId());
            customers.setPhone(customersDTO.getPhone());

            Tenants tenant = tenantsRepo.findById(customersDTO.getTenantId())
                    .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + customersDTO.getTenantId()));
            customers.setTenants(tenant);


            customers.setEmail(customersDTO.getEmail());
            customers.setAddress(customersDTO.getAddress());
            customers.setName(customersDTO.getName());
            customers.setCreatedAt(customersDTO.getCreatedAt());
            return customersRepo.save(customers);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Customers deleteCustomers(int id) {
        Customers customers = customersRepo.findById(id)
                .orElseThrow(()->new RuntimeException("customers not found with id"+id));
        customers.setDeleted(true);
        return customersRepo.save(customers);

    }
}
