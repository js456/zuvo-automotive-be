package com.zuvocloud.automotive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zuvocloud.automotive.dto.TenantsDTO;
import com.zuvocloud.automotive.entity.Tenants;
import com.zuvocloud.automotive.repository.TenantsRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantsServices {
    @Autowired
    private TenantsRepo tenantsRepo;
    private TenantsDTO tenantsDTO;

    public List<TenantsDTO> getAll() {
        List<Tenants>tenants = tenantsRepo.findAll();
        List<TenantsDTO>tenantsDTOS = new ArrayList<>();
        for (Tenants tenants1:tenants){
            TenantsDTO tenantsDTO = new TenantsDTO();
            tenantsDTO.setId(tenants1.getId());
            tenantsDTO.setName(tenants1.getName());
            tenantsDTO.setPhone(tenants1.getPhone());
            tenantsDTO.setCreatedAt(tenants1.getCreatedAt());
            tenantsDTO.setCity(tenants1.getCity());
            tenantsDTO.setAddress(tenants1.getAddress());
            tenantsDTO.setState(tenants1.getState());
            tenantsDTO.setZipCode(tenants1.getZipCode());
            tenantsDTOS.add(tenantsDTO);
        }
        return tenantsDTOS;
    }

    public Tenants findById(int id){
        Tenants tenants =tenantsRepo.findById(id)
                .orElseThrow(()->new RuntimeException("tenants not found with id"+id));
        return tenants;
    }
    public Tenants createTenants(TenantsDTO tenantsDTO){
        try {
            Tenants tenants = new Tenants();
            tenants.setId(tenantsDTO.getId());
            tenants.setAddress(tenantsDTO.getAddress());
            tenants.setCity(tenantsDTO.getCity());
            tenants.setState(tenantsDTO.getState());
            tenants.setCreatedAt(tenantsDTO.getCreatedAt());
            tenants.setZipCode(tenantsDTO.getZipCode());
            tenants.setName(tenantsDTO.getName());
            tenants.setPhone(tenantsDTO.getPhone());
            Tenants tenants1 = tenantsRepo.save(tenants);
            return tenants1;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Tenants updateTenants(TenantsDTO tenantsDTO){
        try {
            Tenants tenants = new Tenants();
            tenants.setId(tenantsDTO.getId());
            tenants.setAddress(tenantsDTO.getAddress());
            tenants.setCity(tenantsDTO.getCity());
            tenants.setState(tenantsDTO.getState());
            tenants.setCreatedAt(tenantsDTO.getCreatedAt());
            tenants.setZipCode(tenantsDTO.getZipCode());
            tenants.setName(tenantsDTO.getName());
            tenants.setPhone(tenantsDTO.getPhone());
            Tenants tenants1 = tenantsRepo.save(tenants);
            return tenants1;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Tenants deleteTenants(int id){
        Tenants tenants =tenantsRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Tenants not found with id"+id));
        tenants.setDeleted(true);
        return tenantsRepo.save(tenants);

    }
}
